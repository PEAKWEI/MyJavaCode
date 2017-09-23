package org.dgw.student;

public class EceptonDemo extends Exception{
	public EceptonDemo(){
		System.out.println("自定义异常类");
	}
	
	public static void showArea() throws EceptonDemo {
		throw new EceptonDemo();
		
	}
	public static void main(String[] args) throws EceptonDemo {
		showArea();
	}
	
}
