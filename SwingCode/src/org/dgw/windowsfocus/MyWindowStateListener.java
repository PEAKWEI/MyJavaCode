package org.dgw.windowsfocus;

import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

public class MyWindowStateListener implements WindowStateListener {

	@Override
	public void windowStateChanged(WindowEvent e) {
			int newstate =e.getNewState();
			int oldstate =e.getOldState();
			
			
				if (newstate==1) {
					System.out.println("ͼ��");
				}
				if (oldstate==6) {
					System.out.println("���");
				}
				
			
	}

}
