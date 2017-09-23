package org.dgw.jprocess;

public class ThreadStop implements Runnable{

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * stop() 现在已经废纸， 推荐使用boolean类型进行 flag标记形势退出
	 */
	
	private boolean mycontinue=true;
	public void run() {
		System.out.println("执行一尺");
		while (true) {
			System.out.println("执行一尺");
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
