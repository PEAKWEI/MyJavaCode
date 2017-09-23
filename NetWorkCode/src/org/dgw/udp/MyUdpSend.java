package org.dgw.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MyUdpSend {

	/**
	 * ���ͷ��������ݵ����ܷ� ���շ��������ݵ����ͷ�
	 *  ���Կ���һ���߳� ��ͣģ��������� ���շ���Ҫָ���˿� ���Ϳ��Բ�ָ���˿�
	 */
	public static void main(String[] args) {
		new Thread(){
			@Override
			public void run() {
				send();
			}
		}.start();
		
		new Thread(){
			public void run() {
				rev();
			};
		}.start();
	}

	private static DatagramSocket dSocket;
	private static DatagramPacket dPacket;

	public static void rev() {
		try {
			dSocket = new DatagramSocket();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] buffer = new byte[1024];
		dPacket = new DatagramPacket(buffer, buffer.length);
		try {
			dSocket.receive(dPacket);
			System.out.println("�յ���");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void send() {
		try {
			dSocket = new DatagramSocket(1997);
		} catch (SocketException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String xString = "hello udp!";
		byte[] buf = xString.getBytes();
		try {
			dPacket = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 2222);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			dSocket.send(dPacket);
			System.out.println("������");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
