package org.dgw.study;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;

import javax.swing.JFrame;

public class TestBorderLayout extends FinalFrame{
	
	/**
	 * borderlayout ��swing��Ĭ�ϵĲ��ַ�ʽ�ģ�������Ҳ�������ʽlayout
	 * jf��add������һ�����Ծ�������borderlayout���������ֵ���ֱ�����ϱ����������Ҷ���
	 * @param args
	 */
		public static void main(String[] args) {
			JFrame jf1=new JFrame("�߿򲼾�");
			jf1.setSize(Winth, Height);
			jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c=jf1.getContentPane();
			jf1.setLayout(new BorderLayout());
			String [] borstr={BorderLayout.EAST,BorderLayout.CENTER,BorderLayout.WEST
					,BorderLayout.SOUTH,BorderLayout.NORTH};
			for (int i = 0; i < 5; i++) {
				c.add(borstr[i],new Button("��ť"+i));
				
			}
			jf1.setVisible(true);
		}

}
