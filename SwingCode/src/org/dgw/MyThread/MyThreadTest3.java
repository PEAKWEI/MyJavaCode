package org.dgw.MyThread;

public class MyThreadTest3 implements Runnable {

	public void waitseckend() throws InterruptedException {
      wait(500);
	}

	public void waityear() throws InterruptedException {
		//��д���� ,��һֱ�ȴ�
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
				//thread �ϲ㻹��runable ������ʵ����
				//thread �й��캯���д��� runable target ʵ���Ͼ��Ǵ������
//				MyThreadTest3 threadstate=new MyThreadTest3();
				Thread thread=new Thread(new MyThreadTest3());
				System.out.println("��ǰ�߳�״̬"+thread.getState());
				thread.start();
				//�̵߳ĸ���״̬չʾ
				System.out.println("��ǰ�߳�״̬"+thread.getState());
				Thread.sleep(500);
				System.out.println("��ǰ�߳�״̬"+thread.getState());
				Thread.sleep(1000);
				System.out.println("��ǰ�߳�״̬"+thread.getState());
				new MyThreadTest3().waittonotify();
				System.out.println("��ǰ�߳�״̬"+thread.getState());
				Thread.sleep(1000);
				System.out.println("��ǰ�߳�״̬"+thread.getState());
				
				
			}

}
