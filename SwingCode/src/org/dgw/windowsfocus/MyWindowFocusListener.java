package org.dgw.windowsfocus;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class MyWindowFocusListener implements WindowFocusListener {

	@Override
	public void windowGainedFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("�õ����㣡");
		
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("ʧȥ���㣡");
		
	}

	
}
