package org.dgw.jprocess;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ThreadPriorityTest {


	public ThreadPriorityTest() {
		super();

	}

	public static void main(String[] args) {
		JFrame jF = new JFrame();
		JTable table=new JTable();
		JScrollPane jScrollPane=new JScrollPane(table);
		JButton button=new JButton("确定");
		jF.setLayout(new FlowLayout());
		jF.add(button);
		jF.setTitle("優先級");
		jF.setSize(300, 300);
		jF.setLocationRelativeTo(null);	
		jF.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowActivated(e);
			}
		});
		jF.setVisible(true);
	}

	/*protected void do_actionPerforme(ActionEvent e) {
		String text = textFieldl.getText();
		Integer priority = Integer.parseInt(text);
		int select = table.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setValueAt(priority, select, 2);
	
	}*/

/*	protected void windowActiveted(WindowEvent e) {
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
		Thread[] threads = new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);// 传递数组
		DefaultTableModel dModel = (DefaultTableModel) table.getModel();
		dModel.setRowCount(0);
		Object[] ob = { "线程ID", "线程名称", "优先级" };
		dModel.setColumnIdentifiers(ob);
		for (Thread thread : threads) {
			dModel.addRow(new Object[] { thread.getId(), thread.getName(), thread.getPriority() });

		}
	}*/
}
