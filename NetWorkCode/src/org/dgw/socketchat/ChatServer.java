package org.dgw.socketchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 
 * @author 武汉生物工程学院  by dgw
 *
 */
public class ChatServer {

	private ServerSocket server;
	private Socket socket;
public static void main(String[] args) throws IOException {
	new ChatServer().startServer();
}
	public void startServer() throws IOException {
          server=new ServerSocket(4444);
          socket=server.accept();
          Thread thread=new Thread(new ssocket(socket));
          thread.start();
	}
	
	public class ssocket implements Runnable{
        Socket client;
		public ssocket(Socket client) {
			this.client=client;
		}
		@Override
		public void run() {
			//分别取得输入流输出流 来接收服务器数据类型
			DataOutputStream oStream;
			DataInputStream  iStream;	
			try {
				iStream=new DataInputStream(client.getInputStream());
				oStream=new DataOutputStream(client.getOutputStream());
				while(true){
					Thread.sleep(1000);
					String chat=iStream.readUTF();
					System.out.println("发送的聊天内容是"+chat);
					Thread.sleep(2000);
					oStream.writeUTF(chat);
					System.out.println("已经发送！");
					
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			
		}
		
	}

}
