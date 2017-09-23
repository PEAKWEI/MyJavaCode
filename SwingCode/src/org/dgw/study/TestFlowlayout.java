package org.dgw.study;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class TestFlowlayout extends FinalFrame{

	public static void main(String[] args) {
				
		JFrame jf=new JFrame("流式布局");
		Container c=jf.getContentPane();
		//这里不可以用jpanel来加入中间是组件，jframe是顶级容器 
		//compant 是低级组件 向下依次递减
//		JPanel jp1=new JPanel();
//		jf.getContentPane().add(jp1);
		jf.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		for (int i = 0; i <21; i++) {
			JButton jb1=new JButton("按钮"+i);
			jb1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
						JDialog jd1=new JDialog(jf, "弹窗");
						jd1.setVisible(true);
				}
			});
			c.add(jb1);
			
		}
	
		// 使用流失布局的时候 默认从左向右开始加组件 程序执行的流程也是从上往下执行的，
		//所以必须在组件绘制好以后才能进行最终的显示效果，不然会出现代码正确，而执行
		//效果不到位的现象出现的情况发生 
		jf.setSize(Winth, Height);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
