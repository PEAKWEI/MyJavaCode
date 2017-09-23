package org.dgw.study;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestGirdLayout extends FinalFrame{

	
	/**
	 * girdlayout布局按照从左至右 从上到下的方式执行排列    
	 * 构造方法用于初始化对象 girdlayout（row ,colonm,h,v）
	 * 代表着几行几列   row*colomn=控件的个数 h v代表水平 垂直的间距
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame jf1=new JFrame("表格布局");
		Container c=jf1.getContentPane();
		jf1.setSize(Winth, Height);
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setLayout(new GridLayout(3, 7, 10, 10));
		for (int i = 0; i < 20; i++) {
			c.add(new JButton("按钮"+i));
			
		}
		jf1.setVisible(true);
		
	}
}
