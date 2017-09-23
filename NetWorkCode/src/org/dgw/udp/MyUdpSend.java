package org.dgw.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MyUdpSend {

	/**
	 * 发送方发送数据到接受方 接收方返回数据到发送方
	 *  各自开启一个线程 不停模拟这个过程 接收方需要指定端口 发送可以不指定端口
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
			System.out.println("收到了");
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
			System.out.println("发送了");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
