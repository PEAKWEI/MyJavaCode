package org.dgw.MyThread;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 * 
 * @author by  dgw
 * �߳�����״̬ : �½� �½�(������) ����   �ȴ�    Ӌ�r�ȴ�  �˳�
 *
 */
public class MyThreadTest2 {

	public void runscran() {
		JFrame jf1;

		jf1 = new JFrame("test");
		jf1.setSize(300, 400);
		
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Dimension x = toolkit.getScreenSize();
				double widtd = x.getWidth();
				while (jf1.getLocation().getX()<widtd) {
					 double a=jf1.getLocation().getX();
					 a+=0.1;
					 jf1.setLocation( (int) a+1, (int) a);
					 
				}
				 
			}
		}, "123");
		jf1.setVisible(true);
		thread.start();
	}
	public static void main(String[] args) {
		new MyThreadTest2().runscran();
	}

}
