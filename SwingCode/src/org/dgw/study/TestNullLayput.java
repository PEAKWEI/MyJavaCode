package org.dgw.study;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestNullLayput {

	public static void main(String[] args) {

		JFrame jF = new JFrame("���Բ���");
		JPanel jp = new JPanel();
		jF.setContentPane(jp);
		URL url = TestNullLayput.class.getResource("1.ico");
		ImageIcon Icon = new ImageIcon(url);
		jF.setIconImage(Icon.getImage());

		// ���Բ��־����ò��ֹ���������Ϊ�� ͨ�����������þ����λ�ü��ϡ�
		jF.setLayout(null);
		jF.setBounds(450, 200, 400, 400);
		jF.setResizable(false);
		jF.setVisible(true);
		JButton jb1 = new JButton("����1");
		JButton jb2 = new JButton("����2");
		jb1.setBounds(0, 0, 33, 33);
		jb2.setBounds(55, 55, 35, 35);

		jp.add(jb1);
		jp.add(jb2);

	}

}
