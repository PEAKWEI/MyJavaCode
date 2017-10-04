package org.dgw.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MyUdpRev {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(3555);
		byte[] x=new byte[1024];
		DatagramPacket packet = new DatagramPacket(x,x.length);
		while(true)
		{
			socket.receive(packet);
			System.out.println(new String(packet.getData(), "utf-8"));
		}
	}
}
