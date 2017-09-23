package org.dgw.NetAdresss;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class SwingWorker {
	  
	 private JProgressBar jpb;
	 private JPanel contente;
	 private JButton jButton;
	  void init(){
		JFrame jf=new JFrame("jframe");
		jf.setSize(300, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		contente=new JPanel(new BorderLayout());
		jButton=new JButton("run");
		jpb=new JProgressBar();
	
		jButton.addMouseListener(new MouseAdapter() {
                   
			
			@Override
			public void mouseClicked(MouseEvent e) {
				//super.mouseClicked(e);
				
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					jpb.setValue(i*10);
				}
			}
			
		});
      
	/*	MouseAdapter listener=new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < 10; i++) {
					jpb.setValue(i*10);
					
				}
				
			}
			
		};
	     new Timer(0, (ActionListener) listener);*/
		jpb.setSize(100, 200);
		contente.add(jpb,BorderLayout.NORTH);
		contente.add(jButton,BorderLayout.CENTER);
		jf.setResizable(false);
		jf.add(contente);
		jf.setVisible(true);
	  }
     public static void main(String[] args) {
		new SwingWorker().init();
	}	  
	

}


