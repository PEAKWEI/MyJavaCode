package org.dgw.combox;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxText {
	static Object selected;
	private String[][] xxx = { { "福州市", "厦门市", "泉州市"},
			{ "杭州市", "温州市", "宁波市"}};
	
	private Object[] a() {
		Object[] os = new Object[xxx.length];
		for (int i = 0; i < xxx.length; i++) {
			os[i] = xxx[i][0];
			System.out.println(os[i]);
		}
		return os;
	}
	private Object[] b(Object a) {
		for (int i = 0; i < xxx.length; i++) {
			if (xxx[i][0].equals(a)) {
				Object[] o = new Object[xxx[i].length - 1];
				for (int j = 0; j < o.length; j++)
					o[j] = xxx[i][j + 1];
				return o;
			}
		}
		return new Object[] {};
	}
	public static void main(String[] args) {
		final JLabel label=new JLabel();
		final ComboBoxText ct = new ComboBoxText();
		final JComboBox ca = new JComboBox(ct.a());
		final JComboBox cb = new JComboBox();
		ca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb.removeAllItems();
				selected= ca.getSelectedItem();
				Object[] newItems = ct.b(selected);
				
				for (int i = 0; i < newItems.length; i++)
					cb.addItem(newItems[i]);
			}
		});
		cb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object item = cb.getSelectedItem();
				label.setText(String.valueOf(selected)+item);
			}
		});
		ca.setSelectedIndex(-1);
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
		f.add(ca);
		f.add(cb);
		f.add(label);
		f.setVisible(true);
		f.setSize(200, 100);
	}
}