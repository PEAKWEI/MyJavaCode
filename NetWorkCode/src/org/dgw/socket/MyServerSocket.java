package org.dgw.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * serversocket一次只能连接一个socket 多个连接的情况下 会进入队列效应 最大队列效应有50个
 * 
 * @author 武汉生物工程学院 by dgw 1：通信流程 serversocket 通过accept() 获取到socket（客户端对象）
 *         以及建立连接（客户端端口号与服务器端口号必须一致） 服务端通过取得输入流得到客户端发送信息 通过输出流让客户端的输入流得到数据信息
 *         这样达到通信的目的，客户端同样通过 输出流 或者输出流 达到与服务器通信的目的！
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
			System.out.println(socket.getInetAddress() + "已经连接！");
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
