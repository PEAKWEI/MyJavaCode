package org.dgw.keyevent;

import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sun.glass.ui.TouchInputSupport;

/**
 * java�������¼���ʵ�ַ�ʽ ��û��adapter��ʵ���¼�Ҫ��һ�� ��mouselisterer 1�����ڲ���
 * ֱ����ʵ������ʵ�֣������¼�������ٵ�״̬�²��� 2�����ڲ��� �Լ�дһ������ʵ�ּ��������߼�����һ���� 3�ⲿ�� �Լ�������࣬�����ļ���д�ķ�ʽ
 * 4ͨ���ӿڵ�ʵ�ַ�ʽ
 * 
 * @author Administrator
 *
 */
public class MyKeyEvent extends MyFrameSize {

	private static JTextArea jta1;

	public static void main(String[] args)  {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		JFrame jFr = new JFrame("�����¼�");
        //���ù�� �����������ʾ ����һ������ Ȼ���������ڻ���ʾ�������͵Ĺ������
		jFr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jFr.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		jFr.setAlwaysOnTop(true);
		jta1 = new JTextArea();
		jta1.setLineWrap(true);
		jFr.getContentPane().add(jta1);
		jFr.setSize(width, height);
		jFr.setLocationRelativeTo(null);
		jFr.setVisible(true);
		jta1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�㰴�µ���"+e.getKeyChar());
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�ͷ���");
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getKeyCode());
				
				
			}
		});

	}

}
