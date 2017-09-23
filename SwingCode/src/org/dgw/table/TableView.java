package org.dgw.table;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TableView {
	public static void main(String[] args) {

		JFrame jf1 = new JFrame("ѧ����ʾ�б�");
		Container con = jf1.getContentPane();
		JPanel jp = new JPanel();
		jp.setBorder(new EmptyBorder(2, 3, 3, 2));
		jp.setLayout(new BorderLayout());
		con.add(jp, BorderLayout.CENTER);
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setSize(600, 400);
		JScrollPane jsp1 = new JScrollPane();
		jsp1.setViewportView(gettable());
		jp.add(jsp1);
		jf1.setVisible(true);

	}

	private static JTable gettable() {
		JTable jTable = new JTable();
		jTable.setRowHeight(22);
		String columnNames[] = { "����", "�Ա�", "��������" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		jTable.setModel(model);
		java.util.List<String> student = getStudent();
		for (String str : student) {
			String args[] = str.split(",");
			model.addRow(args);
		}
		return jTable;

	}

	private static java.util.List<String> getStudent() {
		java.util.List<String> list = new ArrayList<String>();
		list.add("������,��,19970725");

		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		while (flag) {
			String stu1;int select;
			System.out.println("������������");
			stu1=scanner.nextLine();
			System.out.println("ѡ���Ա� 1:��  2:Ů");
			select=scanner.nextInt();
			if (select==1) {
				stu1+=",��";
				System.out.println("������������£�");
				stu1+=","+scanner.nextLine();
				list.add(stu1);
				System.out.println("����exit �˳���");
				flag=false;
			}
			stu1+=",Ů";
			System.out.println("������������£�");
			stu1+=","+scanner.nextLine();
			list.add(stu1);
			System.out.println("����exit �˳���");
			if (scanner.nextLine()=="exit") {
				flag=false;
			}
			
			

		}
		return list;

	}

}
