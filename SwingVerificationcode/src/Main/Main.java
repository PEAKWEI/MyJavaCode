package Main;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @version 1.0
 * @author DGW-PC
 */
public class Main extends JFrame{

    Main(){
          setSize(400,100);
          setLocationRelativeTo(null);
          add(new myVerification());
          setVisible(true);
      }

    public static void main(String[] args) {
        new Main();
    }

}

class myVerification extends JPanel{

    public static final int WIDTH=200;
    public static final int HEIGTH=300;

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(0,0,WIDTH,   HEIGTH);
        g.setColor(Color.BLACK);
        g.drawRect(0,0,WIDTH-1,HEIGTH-1);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int x=random.nextInt(WIDTH)-2;
            int y=random.nextInt(HEIGTH)-2;
            g.drawOval(x,y,2,2);
        }
        g.setFont(new Font("黑体",Font.BOLD,60));
        g.setColor(Color.black);
        char[] chars = ".abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            int i1 = random.nextInt(chars.length);
            char c = chars[i1];
            b.append(c + "");
        }
        g.drawString(b.toString(),30,40);
    }
}

