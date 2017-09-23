package org.dgw.NetAdresss;

import java.net.InetAddress;
import java.net.UnknownHostException;
public class Adresss {
	
 
	public static void main(String[] args) throws UnknownHostException {
		InetAddress inetAddress = InetAddress.getLocalHost();
		System.out.println(inetAddress.toString());
		System.out.println(inetAddress.getHostName());
		System.out.println(inetAddress.getAddress());
		System.out.println(inetAddress.getHostAddress());
	}
	public Adresss() {

		System.out.println("s");
		String xString="a";
	}

}
