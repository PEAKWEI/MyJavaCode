package org.dgw.jprocess;

public class ThreadStop implements Runnable{

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * stop() �����Ѿ���ֽ�� �Ƽ�ʹ��boolean���ͽ��� flag��������˳�
	 */
	
	private boolean mycontinue=true;
	public void run() {
		System.out.println("ִ��һ��");
		while (true) {
			System.out.println("ִ��һ��");
			if (mycontinue) {
				break;
			}
		}
		
	}
	public void getContinue(){
		
		this.mycontinue=false;
	}
			public static void main(String[] args) {
				   new ThreadStop().getContinue();
			}
}
