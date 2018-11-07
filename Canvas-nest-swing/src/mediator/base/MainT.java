package mediator.base;

import javax.swing.*;

/**
 * @program: Lear-Java
 * @description: 测试
 * @author: Mr.Dai
 * @create: 2018-10-27 21:53
 **/
public class MainT {

    public static void main(String[] args) {
        LoginFrame frame = new LoginFrame("Login Test");
        frame.setEnabled(true);
        
        JFrame jFrame = new JFrame();
        frame.setSize(400, 400);
        frame.show();


    }
}
