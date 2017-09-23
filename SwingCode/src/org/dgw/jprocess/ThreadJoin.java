package org.dgw.jprocess;

import java.awt.BorderLayout;
import java.nio.channels.InterruptedByTimeoutException;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

/**
 * 
 * @author �人���﹤��ѧԺ by ��� dgw
 *
 */
public class ThreadJoin extends JFrame{
	
	private Thread threadA;
	private Thread threadB;
	final JProgressBar jpBar =new JProgressBar();
	final JProgressBar jpBar2=new JProgressBar();
	
	public ThreadJoin() {
			super();
			getContentPane().add(jpBar, BorderLayout.NORTH);
			getContentPane().add(jpBar2, BorderLayout.SOUTH);
			jpBar.setStringPainted(true);
			jpBar2.setStringPainted(true);
			
			threadA=new Thread(new Runnable() {
				int count=0;
				@SuppressWarnings("static-access")
				@Override
				public void run() {
					while (true) {
						System.out.println("A��ʼִ��");
						jpBar.setValue(++count);
						jpBar.setValue(++count);
						try {
							threadB.join();
							threadA.sleep(100);
							//�����threadb���۷���ǰ�����Ǻ��� �̻߳���ֻ��ִ��һ�δ���
							//threadB.join();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				
					
					
					
				}
				
			});
			threadA.start();
			threadB=new Thread(new Runnable() {
				int count=0;
				@SuppressWarnings("static-access")
				@Override
				public void run() {
					while (true) {
						System.out.println("B ��ʼִ��");
						jpBar2.setValue(++count);
						try {
							threadB.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							System.out.println("�߳��ж�");
							e.printStackTrace();
						}
						if (count==100) {
							break;
						}
					}
					
				}
			});
			threadB.start();
			threadB.interrupt();
		
	}
	   
	 public static void main(String[] args) {
		 init(new ThreadJoin(),100,100);
	}

	private static void init(JFrame jframe,int x,int y) {
		 jframe.setSize(x, y);
		 jframe.setLocationRelativeTo(null);
		 jframe.setVisible(true);
		
		
	}
	 

}
