package org.dgw.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * serversocketһ��ֻ������һ��socket ������ӵ������ ��������ЧӦ ������ЧӦ��50��
 * 
 * @author �人���﹤��ѧԺ by dgw 1��ͨ������ serversocket ͨ��accept() ��ȡ��socket���ͻ��˶���
 *         �Լ��������ӣ��ͻ��˶˿ں���������˿ںű���һ�£� �����ͨ��ȡ���������õ��ͻ��˷�����Ϣ ͨ��������ÿͻ��˵��������õ�������Ϣ
 *         �����ﵽͨ�ŵ�Ŀ�ģ��ͻ���ͬ��ͨ�� ����� ��������� �ﵽ�������ͨ�ŵ�Ŀ�ģ�
 *
 */
public class MyServerSocket {

	private ServerSocket server;
	private Socket socket;
	public void getServer() throws IOException {
		server = new ServerSocket(4321,2);
		System.out.println(InetAddress.getLocalHost());
		while (true) {
			socket = server.accept();
			System.out.println(socket.getInetAddress() + "�Ѿ����ӣ�");
			//reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//getMessage();
			InputStream iStream;
			iStream=socket.getInputStream();
			
			//String xString=reader.readLine().toString();
			//System.out.println(xString);
			while (true) {
				iStream.read("hello server!".getBytes());
			}
		}

	}

	public static void main(String[] args) throws IOException {
		MyServerSocket my1=new MyServerSocket();
		my1.getServer();
	}

}
