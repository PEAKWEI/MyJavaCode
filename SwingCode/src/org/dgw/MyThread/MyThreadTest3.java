package org.dgw.MyThread;

public class MyThreadTest3 implements Runnable {

	public void waitseckend() throws InterruptedException {
      wait(500);
	}

	public void waityear() throws InterruptedException {
		//不写参数 ,将一直等待
		wait();
	}

	public void waittonotify() {
              notify();
	}

	@Override
	public void run() {
			try {
				waitseckend();
				waityear();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
			public static void main(String[] args) throws InterruptedException {
				//thread 上层还是runable ，存在实现类
				//thread 中构造函数中存在 runable target 实际上就是传入参数
//				MyThreadTest3 threadstate=new MyThreadTest3();
				Thread thread=new Thread(new MyThreadTest3());
				System.out.println("当前线程状态"+thread.getState());
				thread.start();
				//线程的各种状态展示
				System.out.println("当前线程状态"+thread.getState());
				Thread.sleep(500);
				System.out.println("当前线程状态"+thread.getState());
				Thread.sleep(1000);
				System.out.println("当前线程状态"+thread.getState());
				new MyThreadTest3().waittonotify();
				System.out.println("当前线程状态"+thread.getState());
				Thread.sleep(1000);
				System.out.println("当前线程状态"+thread.getState());
				
				
			}

}
