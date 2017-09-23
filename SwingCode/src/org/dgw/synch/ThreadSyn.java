package org.dgw.synch;

public class ThreadSyn {
	
	public ThreadSyn() {
		// TODO Auto-generated constructor stub
	}

	public synchronized void name() {
		System.out.println(Messages.getString("ThreadSyn.0")); //$NON-NLS-1$
		System.out.println("hello word");
	}
	public static void main(String[] args) {
		String xString="hello word";
		String x = "java";
		System.out.println(x);
	}

}
