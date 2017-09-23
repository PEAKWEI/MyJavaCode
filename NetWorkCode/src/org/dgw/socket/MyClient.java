package org.dgw.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {
	private static Socket socket;
	private static String host="192.168.128.1";
	private static int port=4321;
	public static void main(String[] args) throws UnknownHostException, IOException {
		socket=new Socket(host, port);
	/*	BufferedWriter BufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		BufferedWriter.write("hello server!");*/
		InputStream iStream;
		iStream=socket.getInputStream();
		BufferedReader bReader=new BufferedReader(new InputStreamReader(iStream));
		
		while (true) {
			System.out.println(bReader.readLine());
		}
		
	}
}
