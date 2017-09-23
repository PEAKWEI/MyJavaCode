package org.dgw.socketchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {
	private Socket socket;
	private DataInputStream inStream;
	private DataOutputStream ouStream;
	private Scanner scanner;
	private String host="192.168.128.1";
	private int port =4444;
	
	public void putMessage() throws UnknownHostException, IOException{
		socket=new Socket(host, port);
		inStream=new DataInputStream(socket.getInputStream());
		ouStream=new DataOutputStream(socket.getOutputStream());
		Thread thread=new Thread(new chatMoniter(inStream));
		thread.start();
		while(true){
			scanner=new Scanner(System.in);
			String str=scanner.nextLine();
			ouStream.writeUTF(str);
		}
		
	}
	public class chatMoniter implements Runnable{
       private DataInputStream instream;
		
		public void run() {
			while(true){
				try {
					String string=instream.readUTF();
					System.out.println("收到消息"+string);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		}
		public chatMoniter(DataInputStream instream) {
			
			this.instream = instream;
		}
		
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		new ChatClient().putMessage();
	}

}
