package org.dgw.MyThread;

public class MyThreadTest extends Thread{
	 		
	       @Override
	    public void run() {
	    	   int count=10;
	    	   while(true){
	    		   System.out.println("÷¥––¡À"+count+"¥Œ");
	    		   try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					e.getMessage();
				}
	    		   if ((--count)==0) {
	    			  break;
				}
	    	   }
	       }
	       public static void main(String[] args) {
			new MyThreadTest().start();
		}
}
