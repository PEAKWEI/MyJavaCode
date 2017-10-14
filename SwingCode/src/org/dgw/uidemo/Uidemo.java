package org.dgw.uidemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
/**
 * 
 * @author 武汉生物工程学院 by dgw
 *
 */
public class Uidemo {
	
	public static void main(String[] args) {
		         EventQueue.invokeLater(new Runnable() {
					
		        	//这样写为swing的线程安全问题 ，能得到缓解
		        	/*org.jvnet.substance.skin.SubstanceBusinessLookAndFeel
		        	 * 替换上面那一条语句可以达到更换ui的目地
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
    	     //不写这一条uimanner不会有任何作用
    		 JFrame.setDefaultLookAndFeelDecorated(true);
    		 JFrame jframe=new JFrame("UIDEMO");
             jframe.setLocationRelativeTo(null);
             jframe.setSize(400, 200);
             jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             jframe.setVisible(true);
		}
     }
	

}
