package org.dgw.threadprovity;

public class ThreadProvithy {
	
	
	public static void main(String[] args) {
	   Thread thread=new Thread(new Jointhread());
	   thread.start();
	   for (int i = 0; i < 6; i++) {
		   try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   System.out.println("紧急情况"+i+"号车出发！");
		 //保证下面的提前被执行，不过也不能强制保证他执行！
	     try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	   
	
	}

}
/*Runnable() {

@Override
public void run() {
      while (true) {
			for (int i = 0; i < 6; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("紧急情况"+i+"号车出发！");
			}
		}
	
}
});*/