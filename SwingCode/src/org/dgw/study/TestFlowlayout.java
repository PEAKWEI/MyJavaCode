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
				
		JFrame jf=new JFrame("��ʽ����");
		Container c=jf.getContentPane();
		//���ﲻ������jpanel�������м��������jframe�Ƕ������� 
		//compant �ǵͼ���� �������εݼ�
//		JPanel jp1=new JPanel();
//		jf.getContentPane().add(jp1);
		jf.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		for (int i = 0; i <21; i++) {
			JButton jb1=new JButton("��ť"+i);
			jb1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
						JDialog jd1=new JDialog(jf, "����");
						jd1.setVisible(true);
				}
			});
			c.add(jb1);
			
		}
	
		// ʹ����ʧ���ֵ�ʱ�� Ĭ�ϴ������ҿ�ʼ����� ����ִ�е�����Ҳ�Ǵ�������ִ�еģ�
		//���Ա�����������ƺ��Ժ���ܽ������յ���ʾЧ������Ȼ����ִ�����ȷ����ִ��
		//Ч������λ��������ֵ�������� 
		jf.setSize(Winth, Height);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
