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
	
	// 界面初始化
	private void init() {
		frame = new JFrame("服务器端");
		contentArea = new JTextArea();
		contentArea.setEditable(false);// 不可编辑
		contentArea.setForeground(Color.BLUE);// 前景色
		txt_message = new JTextField();
		txt_max = new JTextField("30");// 最大连接
		txt_port = new JTextField("8888");// 端口,默认8888
		btn_start = new JButton("启动");
		btn_stop = new JButton("停止");
		btn_send = new JButton("发送");
		btn_stop.setEnabled(false);// 默认不能用
		listModel = new DefaultListModel();
		userList = new JList(listModel);

		southPanel = new JPanel(new BorderLayout());
		southPanel.setBorder(new TitledBorder("写消息"));
		southPanel.add(txt_message, "Center");
		southPanel.add(btn_send, "East");

		leftPanel = new JScrollPane(userList);
		leftPanel.setBorder(new TitledBorder("在线用户"));

		rightPanel = new JScrollPane(contentArea);
		rightPanel.setBorder(new TitledBorder("消息显示区"));

		centerPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
		centerPanel.setDividerLocation(100);

		northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1, 6));
		northPanel.add(new JLabel("人数上限"));
		northPanel.add(txt_max);
		northPanel.add(new JLabel("端口"));
		northPanel.add(txt_port);
		northPanel.add(btn_start);
		northPanel.add(btn_stop);
		northPanel.setBorder(new TitledBorder("配置信息"));

		frame.setLayout(new BorderLayout());
		frame.add(northPanel, "North");
		frame.add(centerPanel, "Center");
		frame.add(southPanel, "South");
		frame.setSize(600, 400);

		// 设置窗体居中显示
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int x = ((int) screenSize.getWidth() - frame.getWidth()) / 2;
		int y = ((int) screenSize.getHeight() - frame.getHeight()) / 2;
		frame.setLocation(x, y);
		frame.setVisible(true);

		myEvent();//注册事件
	}

	// 事件
	private void myEvent() {
		// 窗口关闭事件
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// 关闭窗口判断服务是否启动
				if (isStart) {
					// 关闭服务器
					closeServer();
				}
				System.exit(0);// 系统停止
			}
		});

		// 文本框按回车键事件
		txt_message.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
		// 单机发送按钮时时间
		btn_send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});

		// 单机启动服务器按钮时事件
		btn_start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isStart) {
					JOptionPane.showMessageDialog(frame, "服务器已经处于启动状态，不要重复启动！", "错误", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int max;
				int port;
				
				try {
					try {
						max=Integer.parseInt(txt_max.getText());
					} catch (Exception e1) {
						throw new Exception("人数上限为正整数");
					}
					try {
						port=Integer.parseInt(txt_port.getText());
					} catch (Exception e1) {
						throw new Exception("端口号为正整数");
					}
					if(port<=0){
						throw new Exception("端口号为正整数");
					}
					//启动服务
					startServer(max,port);
					contentArea.append("服务器已成功启动！人数上限："+max+",端口："+port+"\r\n");
					JOptionPane.showMessageDialog(frame, "服务器启动成功");
					//按钮及输入框状态设置
					txt_max.setEnabled(false);
					txt_port.setEnabled(false);
					btn_start.setEnabled(false);
					btn_stop.setEnabled(true);
					
				} catch (Exception e1) {
					JOptionPane.showConfirmDialog(frame, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		//单机停止服务器按钮事件
		btn_stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!isStart){
					JOptionPane.showMessageDialog(frame, "服务器还未启动，无需停止！", "错误", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					closeServer();
					txt_max.setEnabled(true);
					txt_port.setEnabled(true);
					btn_start.setEnabled(true);
					btn_stop.setEnabled(false);
					contentArea.append("服务器成功停止！\r\n");
					JOptionPane.showMessageDialog(frame, "服务器成功停止！");
				} catch (Exception e1) {
					JOptionPane.showConfirmDialog(frame, "停止服务器发生异常","错误",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		

	}

	// 发送信息
	public void send() {
		if(!isStart){
			JOptionPane.showMessageDialog(frame, "服务器还未启动，不能发送！","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(clients.size()==0){
			JOptionPane.showMessageDialog(frame, "没有用户在线不能发送消息！","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		String message=txt_message.getText().trim();
		if(message==null||"".equals(message)){
			JOptionPane.showMessageDialog(frame, "消息不能为空！","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		sendServerMessage(message);// 群发服务器消息  
		contentArea.append("服务器说："+txt_message.getText()+"\r\n");
		txt_message.setText(null);
	}

    // 群发服务器消息  
    public void sendServerMessage(String message) {  
        for (int i = clients.size() - 1; i >= 0; i--) {  
            clients.get(i).getWriter().println("服务器：" + message + "(多人发送)");  
            clients.get(i).getWriter().flush();  
        }  
    }  
    
	//启动服务
	public void startServer(int max,int port) throws BindException{
		try {
			clients=new ArrayList<ClientThread>();
			serverSocket=new ServerSocket(port);
			serverThread=new ServerThread(serverSocket,max);
			serverThread.start();
			isStart=true;
		} catch (BindException e) {
			isStart=false;
			throw new BindException("端口号已被占用，请换一个!");
		} catch (Exception e) {
			e.printStackTrace();
			isStart=false;
			throw new BindException("端口号已被占用，请换一个!");
		}
	}

	//关闭服务
	public void closeServer(){
		try {
			if(serverThread!=null){
				serverThread.stop();
				for(int i=clients.size()-1;i>=0;i--){
					//给所有在线用户发送关闭命令
					PrintWriter sp = clients.get(i).getWriter();
					sp.println("CLOSE");
					sp.flush();
					sp.close();
					//释放资源
					clients.get(i).stop();//停止词条为客户端服务的线程
					clients.get(i).reader.close();
					clients.get(i).writer.close();
					clients.get(i).socket.close();
					clients.remove(i);
				}
				if(serverSocket!=null){
					serverSocket.close();//关闭服务器端连接
				}
				listModel.removeAllElements();//清空用户列表
				isStart=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isStart=true;
		}
	}
	
	
	
	
	
	
	
	//--------------------------------------------------------------------------------------
	//服务线程
	
	class ServerThread extends Thread{

		private ServerSocket server;
		private int max;//人数上限
		
		public ServerThread(ServerSocket server,int max) {
			this.server=server;
			this.max=max;
		}
		
		@Override
		public void run() {
			while(true){//循环不停的等待客户端的连接
				
				try {
					Socket socket=server.accept();
					if(clients.size()==max){//如果人数已达上限
						BufferedReader r=new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintWriter w=new PrintWriter(socket.getOutputStream());
						//接收客户端的基本用户信息
						String ifo = r.readLine();
						StringTokenizer st=new StringTokenizer(ifo, "@");
						User user=new User(st.nextToken(), st.nextToken());
						//反馈链接成功信息
						w.println("MAX@服务器：对不起，"+user.getName()+","+user.getIp()+",服务器在线人数已达到上限，请稍后尝试连接");
						w.flush();
						//释放资源
						r.close();
						w.close();
						socket.close();
						continue;
					}else{
						ClientThread client=new ClientThread(socket);
						client.start();//开启对此客户端服务的线程
						clients.add(client);
						
						 listModel.addElement(client.getUser().getName());// 更新在线列表  
		                 contentArea.append(client.getUser().getName() +","+ 
		                            client.getUser().getIp() + "上线!\r\n");  
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		
		
	}

	
	//为每一个客户端服务的线程
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
		
		//客户端线程的构造方法
		public ClientThread(Socket socket){
			try {
				this.socket=socket;
				reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer=new PrintWriter(socket.getOutputStream());
				//接收客户端的基本用户信息
				String inf = reader.readLine();
				StringTokenizer st=new StringTokenizer(inf, "@");
				user=new User(st.nextToken(), st.nextToken());
				//反馈链接成功信息
				writer.println(user.getName()+","+user.getIp()+"，与服务器连接成功");
				writer.flush();
				//反馈当前在线用户信息
				if(clients.size()>0){
					String temp="";
					for(int i=clients.size()-1;i>=0;i--){
						temp+=clients.get(i).getUser().getName()+"/"+clients.get(i).getUser().getIp()+"@";
					}
					writer.println("USERLIST@"+clients.size()+"@"+temp);
					writer.flush();
				}
				//向所有在线用户发送该用户上限命令
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
			//不断接受客户端的消息，进行处理
			String message=null;
			while(true){
				
				try {
					message=reader.readLine();//接受客户端消息
					if(message.equals("CLOSE")){//下线命令
						contentArea.append(this.getUser().getName()+","+this.getUser().getIp()+",下线！\r\n");
						//断开连接释放资源
						reader.close();
						writer.close();
						socket.close();
						
						//向所有在线用户发送该用户下线的命令
						for(int i=clients.size()-1;i>=0;i--){
							PrintWriter pw = clients.get(i).getWriter();
							pw.println("DELETE@"+user.getName());
							pw.flush();
						}
						listModel.removeElement(user.getName());//更新在线列表
						//删除此条客户端服务线程
						for(int i=clients.size()-1;i>=0;i--){
							if(clients.get(i).getUser()==user){
								ClientThread temp=clients.get(i);
								clients.remove(i);//删除此用户的服务线程
								temp.stop();//停止这条服务线程
								return;
							}
						}
						
					}else{
						dispatchMessage(message);//转发消息
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
            message = source + "说：" + content;  
            contentArea.append(message + "\r\n");  
            if (owner.equals("ALL")) {// 群发  
                for (int i = clients.size() - 1; i >= 0; i--) {  
                    clients.get(i).getWriter().println(message + "(多人发送)");  
                    clients.get(i).getWriter().flush();  
                }  
            }  
		}
		
		
	}
	
	
	
}
