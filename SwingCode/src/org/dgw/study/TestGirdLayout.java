package org.dgw.study;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestGirdLayout extends FinalFrame{

	
	/**
	 * girdlayout���ְ��մ������� ���ϵ��µķ�ʽִ������    
	 * ���췽�����ڳ�ʼ������ girdlayout��row ,colonm,h,v��
	 * �����ż��м���   row*colomn=�ؼ��ĸ��� h v����ˮƽ ��ֱ�ļ��
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame jf1=new JFrame("��񲼾�");
		Container c=jf1.getContentPane();
		jf1.setSize(Winth, Height);
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setLayout(new GridLayout(3, 7, 10, 10));
		for (int i = 0; i < 20; i++) {
			c.add(new JButton("��ť"+i));
			
		}
		jf1.setVisible(true);
		
	}
}
