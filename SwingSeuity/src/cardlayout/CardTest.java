package cardlayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class CardTest extends JFrame {

	private Container con;
	private JButton jButton;
	private JSplitPane jSplitPane;
	private JPanel jPanel;
	private CardLayout card;

	public CardTest() {
		con = this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		con.setLayout(new BorderLayout());
		jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		jSplitPane.setDividerSize(10);
		jSplitPane.setDividerLocation(90);
		jPanel = new JPanel();
		jPanel.setLayout(card=new CardLayout());
		for (int i = 0; i < 10; i++) {
			jPanel.add(new JLabel("±êÇ©" + i, JLabel.CENTER));
		}
		jSplitPane.setLeftComponent(jPanel);
		jButton=new JButton("key");
		jButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		               if (e.getButton()==MouseEvent.BUTTON1) {
						card.next(jPanel);
					}
			}
		});
		jSplitPane.setRightComponent(jButton);
		con.add(jSplitPane);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new CardTest();
	}

}
