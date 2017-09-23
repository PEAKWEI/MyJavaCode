package org.dgw.keyevent;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * java中四种事件的实现方式 ，没有adapter的实现事件要多一点 如mouselisterer 1匿名内部类
 * 直接在实现类中实现，具体事件代码较少的状态下采用 2命名内部类 自己写一个类来实现监听，或者集成上一个类 3外部类 自己定义的类，建立文件书写的方式
 * 4通过接口的实现方式
 * 
 * @author Administrator
 *
 */
public class MyKeyEvent2 extends MyFrameSize {

	public static void main(String[] args) {
		JFrame jFr = new JFrame("键盘事件");
		JTextArea jta1 = new JTextArea();
		jta1.setLineWrap(true);
		jFr.getContentPane().add(jta1);
		jFr.setSize(width, height);
		jFr.setLocationRelativeTo(null);
		jFr.setVisible(true);
		jta1.addKeyListener(new mykeylistener());
		
	}
	

}


