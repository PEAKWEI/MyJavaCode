package org.dgw.mouse;

import javax.swing.JFrame;

public class Mymouse extends JFrame{
	
	public Mymouse()  {
		init();
	}

	private void init() {
		
		this.setTitle("jframe继承类的实现");
		this.setResizable(false);
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
            
		new Mymouse();
	}

}
