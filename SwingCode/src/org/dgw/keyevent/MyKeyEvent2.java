package org.dgw.keyevent;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * java�������¼���ʵ�ַ�ʽ ��û��adapter��ʵ���¼�Ҫ��һ�� ��mouselisterer 1�����ڲ���
 * ֱ����ʵ������ʵ�֣������¼�������ٵ�״̬�²��� 2�����ڲ��� �Լ�дһ������ʵ�ּ��������߼�����һ���� 3�ⲿ�� �Լ�������࣬�����ļ���д�ķ�ʽ
 * 4ͨ���ӿڵ�ʵ�ַ�ʽ
 * 
 * @author Administrator
 *
 */
public class MyKeyEvent2 extends MyFrameSize {

	public static void main(String[] args) {
		JFrame jFr = new JFrame("�����¼�");
		JTextArea jta1 = new JTextArea();
		jta1.setLineWrap(true);
		jFr.getContentPane().add(jta1);
		jFr.setSize(width, height);
		jFr.setLocationRelativeTo(null);
		jFr.setVisible(true);
		jta1.addKeyListener(new mykeylistener());
		
	}
	

}


