package org.dgw.notepaid;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainFrame extends FileUtil {

	static int Winth = 600;
	static int Height = 600;

	public static void main(String[] args) {
		JFrame jFr = new JFrame("Java Version Notepaid");
		Container con = jFr.getContentPane();
		jFr.setSize(Winth, Height);
		jFr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextArea jta = new JTextArea("在这里输入你的文本  按F1 进行保存 ");
		// 这样加入组件才能保证同步刷新 间接加入代码 会发生代码同步错误的
		JScrollPane jsp = new JScrollPane(jta);
		jta.setSize(Winth, Height);
		con.add(jsp);

		jFr.setVisible(true);

		jta.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F1) {

					JFileChooser jfc1 = new JFileChooser();
					if (jfc1.showSaveDialog(jFr) == 0) {
						String string = jta.getText();
						String file = jfc1.getSelectedFile() + "\\";

						try {
							FileWriter filterWriter = new FileWriter(file);
							filterWriter.write(string);
							filterWriter.flush();
							filterWriter.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		jFr.addWindowListener(new WindowListener() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);

			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

		});

	}

}
