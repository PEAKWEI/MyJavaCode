package org.dgw.student;

public class EceptonDemo extends Exception{
	public EceptonDemo(){
		System.out.println("�Զ����쳣��");
	}
	
	public static void showArea() throws EceptonDemo {
		throw new EceptonDemo();
		
	}
	public static void main(String[] args) throws EceptonDemo {
		showArea();
	}
	
}
