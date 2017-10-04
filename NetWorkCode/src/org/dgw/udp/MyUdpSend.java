package org.dgw.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MyUdpSend {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String len;
	    byte[] buf=new byte[1024];
	    DatagramPacket packet = new DatagramPacket(buf, buf.length,InetAddress.getLocalHost(),3555);
	    while((len=reader.readLine())!=null)
	    {
	    	packet.setData(len.getBytes("utf-8"));
	    	socket.send(packet);
	    }
	}

}
