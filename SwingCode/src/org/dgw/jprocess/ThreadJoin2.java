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
public class ThreadJoin2 extends JFrame {

	private static Thread threadA;
	private boolean threadcon=true;
	final static JProgressBar jpBar = new JProgressBar();

	public ThreadJoin2() {
		super();
		getContentPane().add(jpBar, BorderLayout.NORTH);

		jpBar.setStringPainted(true);

		threadA = new Thread(new Runnable() {
			int count = 0;

			@SuppressWarnings("static-access")
			@Override
			public void run() {
				while (threadcon) {
					System.out.println("A��ʼִ��");
					jpBar.setValue(++count);
					try {

						threadA.sleep(100);
						// �����threadb���۷���ǰ�����Ǻ��� �̻߳���ֻ��ִ��һ�δ���
						// threadB.join();
					} catch (InterruptedException e) {
						System.out.println("�߳��ж�");
						//e.printStackTrace();
					}
					if (jpBar.getValue()==100) {
					     threadcon=false;
					}
				}

			}

		});
		threadA.start();
	     //�߳��жϺ󲢲�����ֹ�߳�  ���׳��쳣
		threadA.interrupt();
		threadA.stop();
		//System.out.println(threadA.getState());
	}

	public static void main(String[] args) {
		init(new ThreadJoin2(), 100, 100);
		
	}

	private static void init(JFrame jframe, int x, int y) {
		jframe.setSize(x, y);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);

	}

}
