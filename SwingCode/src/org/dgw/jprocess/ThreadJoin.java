package org.dgw.jprocess;

import java.awt.BorderLayout;
import java.nio.channels.InterruptedByTimeoutException;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

/**
 * 
 * @author 武汉生物工程学院 by 软件 dgw
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
						System.out.println("A开始执行");
						jpBar.setValue(++count);
						jpBar.setValue(++count);
						try {
							threadB.join();
							threadA.sleep(100);
							//这里的threadb无论放在前，还是后面 线程还是只会执行一次代码
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
						System.out.println("B 开始执行");
						jpBar2.setValue(++count);
						try {
							threadB.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							System.out.println("线程中断");
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
