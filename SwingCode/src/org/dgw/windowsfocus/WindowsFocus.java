package org.dgw.windowsfocus;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 * 
 * @author �人���﹤��ѧԺ ����ϵ by  DGW
 *@version swing ���г����¼�������ʵ��
 */
public class WindowsFocus extends JFrame{
	
	private final static int width=400;
	private final static int height=500;
	private  static JTable jta1;
	private static JPanel jPanel;
	private static JScrollPane jsp;
	private  static DefaultTableModel tableModel;
	 
	public WindowsFocus() {
          super();
          this.setSize(width, height);
          JComboBox< String> jcb1=new JComboBox<String>();
          for (int i = 0; i < 5; i++) {
			jcb1.addItem("ѡ��"+i);
		}
          
           jPanel=new JPanel();
           this.add(jcb1);
          tableModel=new DefaultTableModel(5, 3);
    	  jta1=new JTable(tableModel);
    	  this.add(jPanel);
           
    	 
          this.setVisible(true);
          //����
          this.addWindowFocusListener(new MyWindowFocusListener());
          //״̬
          this.addWindowStateListener(new MyWindowStateListener() );
          //���������¼�
          this.addWindowListener(new MyWindowListener());
          //�����б��¼�
          jcb1.addItemListener(new MySelectItem());
	}
	public static void setJtable(){
		String [] columnNames={"ab","s"};
		String [][] rowCounts ={{"123"},{"12312"},{"213123"}};
	

	  
	}
	
	public static void main(String[] args) {
	
		new WindowsFocus();
	}

}
