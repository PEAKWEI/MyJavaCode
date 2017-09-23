package org.dgw.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MyUdpRev {

	private static DatagramPacket dsPacket;
	private static DatagramSocket dSocket;

	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {

				rev();
			}
		}.start();
	}

	public static void rev() {
		try {
			dSocket = new DatagramSocket(2222);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] buf = new byte[2014];
		dsPacket = new DatagramPacket(buf, buf.length);
		try {
			dSocket.receive(dsPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("wo  ’µΩ¡À£°");

	}
}
