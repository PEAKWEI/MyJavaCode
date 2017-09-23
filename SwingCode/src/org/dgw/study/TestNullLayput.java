package org.dgw.study;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestNullLayput {

	public static void main(String[] args) {

		JFrame jF = new JFrame("绝对布局");
		JPanel jp = new JPanel();
		jF.setContentPane(jp);
		URL url = TestNullLayput.class.getResource("1.ico");
		ImageIcon Icon = new ImageIcon(url);
		jF.setIconImage(Icon.getImage());

		// 绝对布局就是让布局管理器设置为空 通过坐标来设置具体的位置集合。
		jF.setLayout(null);
		jF.setBounds(450, 200, 400, 400);
		jF.setResizable(false);
		jF.setVisible(true);
		JButton jb1 = new JButton("这是1");
		JButton jb2 = new JButton("这是2");
		jb1.setBounds(0, 0, 33, 33);
		jb2.setBounds(55, 55, 35, 35);

		jp.add(jb1);
		jp.add(jb2);

	}

}
