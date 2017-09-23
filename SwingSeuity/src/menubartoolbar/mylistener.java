package menubartoolbar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPopupMenu;

public class mylistener implements MouseListener {

	JPopupMenu jPopu;
	public mylistener(JPopupMenu jPop) {
         this.jPopu=jPop;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
        if (e.getButton()==MouseEvent.BUTTON1) {
			jPopu.show(null, e.getX(), e.getY());
		} else {

		}    
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
