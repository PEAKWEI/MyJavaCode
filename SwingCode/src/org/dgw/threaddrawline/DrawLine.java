package org.dgw.threaddrawline;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;


/**
 * 
 * @author 武汉生物工程学院  by dgw   
 *
 */
public class DrawLine extends JFrame {
	  
			private final static Color[] color={Color.BLACK,Color.BLUE,
			Color.GREEN,Color.RED,Color.cyan,Color.LIGHT_GRAY};
		
			private Thread t;
			private static Random ran;
		
			//返回颜色的类型
			public static Color getC(){
				ran=new Random();
				return color[ran.nextInt(color.length)];
			}
			public void colorLine() {
			
				 t=new Thread(new Runnable() {
					 int x=30;
					 int y=50;
					
					@Override
					public void run() {
						
						while(true){
							
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							Graphics graph=getGraphics();
							//drawline x ，y 是从上到下的起始点   后面的 x ，y是定点的增量操作
							graph.setColor(Color.BLACK);
							graph.drawLine(x, y, 100, y++);
							 
							if (y>=80) {
								y=50;
							}
							
						}
					}
				});
				
				 t.start();
							}
			
			public static void main(String[] args) {
				//由于DrawLine 继承了jframe类  这里传递的也是jframe类
				init(new DrawLine(),100,100);
				
			}
			private static void init(JFrame jFrame,int x,int y) {
			     jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			     jFrame.setSize(x, y);
			     jFrame.setLocationRelativeTo(null);
			     jFrame.setVisible(true);
				
			}
}
