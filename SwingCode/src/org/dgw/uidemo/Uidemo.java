package org.dgw.uidemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
/**
 * 
 * @author �人���﹤��ѧԺ by dgw
 *
 */
public class Uidemo {
	
	public static void main(String[] args) {
		         EventQueue.invokeLater(new Runnable() {
					
		        	//����дΪswing���̰߳�ȫ���� ���ܵõ�����
		        	/*org.jvnet.substance.skin.SubstanceBusinessLookAndFeel
		        	 * �滻������һ�������Դﵽ����ui��Ŀ��
		        	*/
					@Override
					public void run() {
						/*// TODO Auto-generated method stub
						try {
							UIManager.setLookAndFeel(new org.jvnet.substance.skin.SubstanceBusinessLookAndFeel());
						} catch (UnsupportedLookAndFeelException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Uidemo.name in=new Uidemo().new name();
						 in.init();*/
						
					}
				});
		         
	             
	}
	
     public  class name{
    	 
    	public void init() {
    	     //��д��һ��uimanner�������κ�����
    		 JFrame.setDefaultLookAndFeelDecorated(true);
    		 JFrame jframe=new JFrame("UIDEMO");
             jframe.setLocationRelativeTo(null);
             jframe.setSize(400, 200);
             jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             jframe.setVisible(true);
		}
     }
	

}
