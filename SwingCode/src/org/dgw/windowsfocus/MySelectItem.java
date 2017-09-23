package org.dgw.windowsfocus;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MySelectItem implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int selectItem=e.getStateChange();
		if (selectItem==ItemEvent.SELECTED) {
			System.out.println("你选了"+e.getItem().toString());
		}else if (selectItem==ItemEvent.DESELECTED) {
			System.out.println("取消了"+e.getItem().toString());		
		}

	}

}
