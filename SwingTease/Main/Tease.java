package Main;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Tease extends JFrame {
	
	private static final long serialVersionUID = 2645156605795276085L;
	private static final int width=600;
	private static final int height=400;
	
	private static final String cot="java 是世上最好的语言!";
	private Container pane;

	public Tease() {
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane = getContentPane();
		pane.setLayout(null);
		JLabel label = new JLabel(cot);
		label.setFont(new Font("粗体", Font.BOLD,15));
		label.setBounds(200,60 , 200, 100);
		JButton byes = new JButton("是的");
		JButton bno = new JButton("不是");
		byes.setBounds(90, 150, 100, 50);
		bno.setBounds(350, 150, 100, 50);
		pane.add(byes);
		byes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int dialog = JOptionPane.showConfirmDialog(null, "恭喜你答对了!", "s",JOptionPane.PLAIN_MESSAGE);
				if (dialog==0) {
					System.exit(0);
				}
			}
			
		});
		bno.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				bno.setBounds(new Random().nextInt(500), new Random().nextInt(300),100, 50);

			}
			@Override
			public void mouseDragged(MouseEvent e) {
				bno.setBounds(new Random().nextInt(500), new Random().nextInt(300),100, 50);
			}
		});
		pane.add(bno);
		pane.add(label);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Tease();
	}

}
