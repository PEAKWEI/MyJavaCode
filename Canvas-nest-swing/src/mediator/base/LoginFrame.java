package mediator.base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: Lear-Java
 * @description: 登录
 * @author: Mr.Dai
 * @create: 2018-10-27 21:19
 **/
public class LoginFrame extends JFrame implements ActionListener,Mediator {

    private ColleagueCheckBox checkGuest;
    private ColleagueCheckBox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonok;
    private ColleagueButton buttonCancel;


    public LoginFrame(String title) throws HeadlessException {
        super(title);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout(4,2));

        createColleagues();

        add(checkGuest);
        add(checkLogin);
        add(new JLabel("UserName"));
        add(textUser);
        add(new JLabel("PassWord"));
        add(textPass);
        add(buttonok);
        add(buttonCancel);

        colleagueChanged();

        pack();
        setEnabled(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }

    @Override
    public void createColleagues() {
        ButtonGroup group = new ButtonGroup();
        checkGuest=new ColleagueCheckBox("Guest",true);
        checkLogin=new ColleagueCheckBox("Login",false);
        group.add(checkGuest);
        group.add(checkLogin);

        textUser=new ColleagueTextField("",10);
        textPass=new ColleagueTextField("",10);
        textPass.setEchoChar('*');


        buttonCancel=new ColleagueButton("Cancel");
        buttonok=new ColleagueButton("OK");
        // set Mediator
        checkLogin.setMediator(this);
        checkGuest.setMediator(this);
        textPass.setMediator(this);
        textUser.setMediator(this);
        buttonok.setMediator(this);
        buttonCancel.setMediator(this);
        // set listener
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);

        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);

        buttonok.addActionListener(this);
        buttonCancel.addActionListener(this);

    }

    @Override
    public void colleagueChanged() {
        if(checkGuest.isSelected()){
            textPass.setEnabled(false);
            textUser.setEnabled(false);
            buttonok.setEnabled(false);
        }else{
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }

    private void userpassChanged() {
        if(textUser.getText().length()>0){
            textPass.setEnabled(true);
            if(textPass.getText().length()>0){
                buttonok.setEnabled(true);
            }else{
                buttonok.setEnabled(false);
            }
        }else{
            textPass.setEnabled(false);
            buttonok.setEnabled(false);
        }

    }
}
