package org.dgw.threaddrawline;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawRect extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Thread thread;
	public DrawRect() {
		   this.add(new myPanel());

           this.setSize(800, 600);
	}
	
	public  class myPanel extends JPanel{
	         /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
			Thread thread=new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
				}
			});
	         
		
	}
	
	
	
	public static void main(String[] args) {
		   new DrawRect().setVisible(true);
	}



}
