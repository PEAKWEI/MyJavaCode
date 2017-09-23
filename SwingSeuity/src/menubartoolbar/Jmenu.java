package menubartoolbar;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

public class Jmenu extends JFrame {

	int sx;
	int sy;
	public JPopupMenu jPopup;
	public JPopupMenu getjPopup() {
		return jPopup;
	}


	public void setjPopup(JPopupMenu jPopup) {
		this.jPopup = jPopup;
	}


	JMenuItem jMenuI;
	Container con;
    JTextArea jText;
	public Jmenu(int x, int y) {
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(x, y);
		con = this.getContentPane();
		jText=new JTextArea();
		jText.setSize(x, y);
		con.add(jText);
		jPopup=new JPopupMenu();
		jPopup.add(new JMenuItem("S"));
		jText.add(jPopup);
		jText.addMouseListener(new mylistener(jPopup));
		this.setVisible(true);

	}
	

	public static void main(String[] args) {
		new Jmenu(300, 400);
	}

}
