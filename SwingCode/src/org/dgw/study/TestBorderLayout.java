package org.dgw.study;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;

import javax.swing.JFrame;

public class TestBorderLayout extends FinalFrame{
	
	/**
	 * borderlayout 是swing中默认的布局方式的，不设置也是这个方式layout
	 * jf中add方法第一个属性就是设置borderlayout方向的属性值，分别代表上北下南左西右东中
	 * @param args
	 */
		public static void main(String[] args) {
			JFrame jf1=new JFrame("边框布局");
			jf1.setSize(Winth, Height);
			jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c=jf1.getContentPane();
			jf1.setLayout(new BorderLayout());
			String [] borstr={BorderLayout.EAST,BorderLayout.CENTER,BorderLayout.WEST
					,BorderLayout.SOUTH,BorderLayout.NORTH};
			for (int i = 0; i < 5; i++) {
				c.add(borstr[i],new Button("按钮"+i));
				
			}
			jf1.setVisible(true);
		}

}
