package org.dgw.toolkit;

public class ExceptionEample  {
	
		public final static int age=1;
		public final static String name="setname";
		public transient int a=1;
		public volatile int b=2;
		public transient volatile int c=3;
	    void myException() throws Exception,NullPointerException,IndexOutOfBoundsException{
	    	 System.out.println("抛出异常类，本省出现的异常的由调用者负责处理！");
	     }
	    public static  synchronized void synCh(){
	    	
	    }
	    public static void main(String[] args) throws myNewException {
			throw new myNewException("s");
		}
        void proDucer(){
        	try {
				myException();
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	
}
