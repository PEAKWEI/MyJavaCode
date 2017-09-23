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
 * java中四种事件的实现方式 ，没有adapter的实现事件要多一点 如mouselisterer 1匿名内部类
 * 直接在实现类中实现，具体事件代码较少的状态下采用 2命名内部类 自己写一个类来实现监听，或者集成上一个类 3外部类 自己定义的类，建立文件书写的方式
 * 4通过接口的实现方式
 * 
 * @author Administrator
 *
 */
public class MyKeyEvent extends MyFrameSize {

	private static JTextArea jta1;

	public static void main(String[] args)  {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		JFrame jFr = new JFrame("键盘事件");
        //设置光标 在面板上有显示 进入一个区域 然后在区域内会显示特殊类型的光标类型
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
				System.out.println("你按下的是"+e.getKeyChar());
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("释放了");
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getKeyCode());
				
				
			}
		});

	}

}
