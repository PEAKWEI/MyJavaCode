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
					System.out.println("A开始执行");
					jpBar.setValue(++count);
					try {

						threadA.sleep(100);
						// 这里的threadb无论放在前，还是后面 线程还是只会执行一次代码
						// threadB.join();
					} catch (InterruptedException e) {
						System.out.println("线程中断");
						//e.printStackTrace();
					}
					if (jpBar.getValue()==100) {
					     threadcon=false;
					}
				}

			}

		});
		threadA.start();
	     //线程中断后并不会终止线程  会抛出异常
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
