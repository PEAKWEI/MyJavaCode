package mychat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Server {

	private JFrame frame;
	private JTextArea contentArea;
	private JTextField txt_message, txt_max, txt_port;
	private JButton btn_start, btn_stop, btn_send;
	private JPanel northPanel, southPanel;
	private JScrollPane rightPanel, leftPanel;
	private JSplitPane centerPanel;
	private JList userList;
	private DefaultListModel listModel;

	private ServerSocket serverSocket;
	private ServerThread serverThread;
	private List<ClientThread> clients;

	private boolean isStart = false;

	public Server(){
		init();
	}
	
	public static void main(String[] args) {
		new Server();
	}
	
	// �����ʼ��
	private void init() {
		frame = new JFrame("��������");
		contentArea = new JTextArea();
		contentArea.setEditable(false);// ���ɱ༭
		contentArea.setForeground(Color.BLUE);// ǰ��ɫ
		txt_message = new JTextField();
		txt_max = new JTextField("30");// �������
		txt_port = new JTextField("8888");// �˿�,Ĭ��8888
		btn_start = new JButton("����");
		btn_stop = new JButton("ֹͣ");
		btn_send = new JButton("����");
		btn_stop.setEnabled(false);// Ĭ�ϲ�����
		listModel = new DefaultListModel();
		userList = new JList(listModel);

		southPanel = new JPanel(new BorderLayout());
		southPanel.setBorder(new TitledBorder("д��Ϣ"));
		southPanel.add(txt_message, "Center");
		southPanel.add(btn_send, "East");

		leftPanel = new JScrollPane(userList);
		leftPanel.setBorder(new TitledBorder("�����û�"));

		rightPanel = new JScrollPane(contentArea);
		rightPanel.setBorder(new TitledBorder("��Ϣ��ʾ��"));

		centerPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
		centerPanel.setDividerLocation(100);

		northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1, 6));
		northPanel.add(new JLabel("��������"));
		northPanel.add(txt_max);
		northPanel.add(new JLabel("�˿�"));
		northPanel.add(txt_port);
		northPanel.add(btn_start);
		northPanel.add(btn_stop);
		northPanel.setBorder(new TitledBorder("������Ϣ"));

		frame.setLayout(new BorderLayout());
		frame.add(northPanel, "North");
		frame.add(centerPanel, "Center");
		frame.add(southPanel, "South");
		frame.setSize(600, 400);

		// ���ô��������ʾ
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int x = ((int) screenSize.getWidth() - frame.getWidth()) / 2;
		int y = ((int) screenSize.getHeight() - frame.getHeight()) / 2;
		frame.setLocation(x, y);
		frame.setVisible(true);

		myEvent();//ע���¼�
	}

	// �¼�
	private void myEvent() {
		// ���ڹر��¼�
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// �رմ����жϷ����Ƿ�����
				if (isStart) {
					// �رշ�����
					closeServer();
				}
				System.exit(0);// ϵͳֹͣ
			}
		});

		// �ı��򰴻س����¼�
		txt_message.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
		// �������Ͱ�ťʱʱ��
		btn_send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});

		// ����������������ťʱ�¼�
		btn_start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isStart) {
					JOptionPane.showMessageDialog(frame, "�������Ѿ���������״̬����Ҫ�ظ�������", "����", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int max;
				int port;
				
				try {
					try {
						max=Integer.parseInt(txt_max.getText());
					} catch (Exception e1) {
						throw new Exception("��������Ϊ������");
					}
					try {
						port=Integer.parseInt(txt_port.getText());
					} catch (Exception e1) {
						throw new Exception("�˿ں�Ϊ������");
					}
					if(port<=0){
						throw new Exception("�˿ں�Ϊ������");
					}
					//��������
					startServer(max,port);
					contentArea.append("�������ѳɹ��������������ޣ�"+max+",�˿ڣ�"+port+"\r\n");
					JOptionPane.showMessageDialog(frame, "�����������ɹ�");
					//��ť�������״̬����
					txt_max.setEnabled(false);
					txt_port.setEnabled(false);
					btn_start.setEnabled(false);
					btn_stop.setEnabled(true);
					
				} catch (Exception e1) {
					JOptionPane.showConfirmDialog(frame, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		//����ֹͣ��������ť�¼�
		btn_stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!isStart){
					JOptionPane.showMessageDialog(frame, "��������δ����������ֹͣ��", "����", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					closeServer();
					txt_max.setEnabled(true);
					txt_port.setEnabled(true);
					btn_start.setEnabled(true);
					btn_stop.setEnabled(false);
					contentArea.append("�������ɹ�ֹͣ��\r\n");
					JOptionPane.showMessageDialog(frame, "�������ɹ�ֹͣ��");
				} catch (Exception e1) {
					JOptionPane.showConfirmDialog(frame, "ֹͣ�����������쳣","����",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		

	}

	// ������Ϣ
	public void send() {
		if(!isStart){
			JOptionPane.showMessageDialog(frame, "��������δ���������ܷ��ͣ�","����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(clients.size()==0){
			JOptionPane.showMessageDialog(frame, "û���û����߲��ܷ�����Ϣ��","����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		String message=txt_message.getText().trim();
		if(message==null||"".equals(message)){
			JOptionPane.showMessageDialog(frame, "��Ϣ����Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		sendServerMessage(message);// Ⱥ����������Ϣ  
		contentArea.append("������˵��"+txt_message.getText()+"\r\n");
		txt_message.setText(null);
	}

    // Ⱥ����������Ϣ  
    public void sendServerMessage(String message) {  
        for (int i = clients.size() - 1; i >= 0; i--) {  
            clients.get(i).getWriter().println("��������" + message + "(���˷���)");  
            clients.get(i).getWriter().flush();  
        }  
    }  
    
	//��������
	public void startServer(int max,int port) throws BindException{
		try {
			clients=new ArrayList<ClientThread>();
			serverSocket=new ServerSocket(port);
			serverThread=new ServerThread(serverSocket,max);
			serverThread.start();
			isStart=true;
		} catch (BindException e) {
			isStart=false;
			throw new BindException("�˿ں��ѱ�ռ�ã��뻻һ��!");
		} catch (Exception e) {
			e.printStackTrace();
			isStart=false;
			throw new BindException("�˿ں��ѱ�ռ�ã��뻻һ��!");
		}
	}

	//�رշ���
	public void closeServer(){
		try {
			if(serverThread!=null){
				serverThread.stop();
				for(int i=clients.size()-1;i>=0;i--){
					//�����������û����͹ر�����
					PrintWriter sp = clients.get(i).getWriter();
					sp.println("CLOSE");
					sp.flush();
					sp.close();
					//�ͷ���Դ
					clients.get(i).stop();//ֹͣ����Ϊ�ͻ��˷�����߳�
					clients.get(i).reader.close();
					clients.get(i).writer.close();
					clients.get(i).socket.close();
					clients.remove(i);
				}
				if(serverSocket!=null){
					serverSocket.close();//�رշ�����������
				}
				listModel.removeAllElements();//����û��б�
				isStart=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isStart=true;
		}
	}
	
	
	
	
	
	
	
	//--------------------------------------------------------------------------------------
	//�����߳�
	
	class ServerThread extends Thread{

		private ServerSocket server;
		private int max;//��������
		
		public ServerThread(ServerSocket server,int max) {
			this.server=server;
			this.max=max;
		}
		
		@Override
		public void run() {
			while(true){//ѭ����ͣ�ĵȴ��ͻ��˵�����
				
				try {
					Socket socket=server.accept();
					if(clients.size()==max){//��������Ѵ�����
						BufferedReader r=new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintWriter w=new PrintWriter(socket.getOutputStream());
						//���տͻ��˵Ļ����û���Ϣ
						String ifo = r.readLine();
						StringTokenizer st=new StringTokenizer(ifo, "@");
						User user=new User(st.nextToken(), st.nextToken());
						//�������ӳɹ���Ϣ
						w.println("MAX@���������Բ���"+user.getName()+","+user.getIp()+",���������������Ѵﵽ���ޣ����Ժ�������");
						w.flush();
						//�ͷ���Դ
						r.close();
						w.close();
						socket.close();
						continue;
					}else{
						ClientThread client=new ClientThread(socket);
						client.start();//�����Դ˿ͻ��˷�����߳�
						clients.add(client);
						
						 listModel.addElement(client.getUser().getName());// ���������б�  
		                 contentArea.append(client.getUser().getName() +","+ 
		                            client.getUser().getIp() + "����!\r\n");  
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		
		
	}

	
	//Ϊÿһ���ͻ��˷�����߳�
	class ClientThread extends Thread{
		
		private Socket socket;
		private BufferedReader reader;
		private PrintWriter writer;
		private User user;
		
		public BufferedReader getReader() {
			return reader;
		}
		public PrintWriter getWriter() {
			return writer;
		}
		public User getUser() {
			return user;
		}
		
		//�ͻ����̵߳Ĺ��췽��
		public ClientThread(Socket socket){
			try {
				this.socket=socket;
				reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer=new PrintWriter(socket.getOutputStream());
				//���տͻ��˵Ļ����û���Ϣ
				String inf = reader.readLine();
				StringTokenizer st=new StringTokenizer(inf, "@");
				user=new User(st.nextToken(), st.nextToken());
				//�������ӳɹ���Ϣ
				writer.println(user.getName()+","+user.getIp()+"������������ӳɹ�");
				writer.flush();
				//������ǰ�����û���Ϣ
				if(clients.size()>0){
					String temp="";
					for(int i=clients.size()-1;i>=0;i--){
						temp+=clients.get(i).getUser().getName()+"/"+clients.get(i).getUser().getIp()+"@";
					}
					writer.println("USERLIST@"+clients.size()+"@"+temp);
					writer.flush();
				}
				//�����������û����͸��û���������
				for(int i=clients.size()-1;i>=0;i--){
					PrintWriter ww = clients.get(i).getWriter();
					ww.println("ADD@"+user.getName()+","+user.getIp());
					ww.flush();
				}
				
			} catch (Exception e) {
				e.printStackTrace();  
			}
		}
		
		
		@Override
		public void run() {
			//���Ͻ��ܿͻ��˵���Ϣ�����д���
			String message=null;
			while(true){
				
				try {
					message=reader.readLine();//���ܿͻ�����Ϣ
					if(message.equals("CLOSE")){//��������
						contentArea.append(this.getUser().getName()+","+this.getUser().getIp()+",���ߣ�\r\n");
						//�Ͽ������ͷ���Դ
						reader.close();
						writer.close();
						socket.close();
						
						//�����������û����͸��û����ߵ�����
						for(int i=clients.size()-1;i>=0;i--){
							PrintWriter pw = clients.get(i).getWriter();
							pw.println("DELETE@"+user.getName());
							pw.flush();
						}
						listModel.removeElement(user.getName());//���������б�
						//ɾ�������ͻ��˷����߳�
						for(int i=clients.size()-1;i>=0;i--){
							if(clients.get(i).getUser()==user){
								ClientThread temp=clients.get(i);
								clients.remove(i);//ɾ�����û��ķ����߳�
								temp.stop();//ֹͣ���������߳�
								return;
							}
						}
						
					}else{
						dispatchMessage(message);//ת����Ϣ
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		private void dispatchMessage(String message) {
			
			StringTokenizer stringTokenizer = new StringTokenizer(message, "@");  
            String source = stringTokenizer.nextToken();  
            String owner = stringTokenizer.nextToken();  
            String content = stringTokenizer.nextToken();  
            message = source + "˵��" + content;  
            contentArea.append(message + "\r\n");  
            if (owner.equals("ALL")) {// Ⱥ��  
                for (int i = clients.size() - 1; i >= 0; i--) {  
                    clients.get(i).getWriter().println(message + "(���˷���)");  
                    clients.get(i).getWriter().flush();  
                }  
            }  
		}
		
		
	}
	
	
	
}
