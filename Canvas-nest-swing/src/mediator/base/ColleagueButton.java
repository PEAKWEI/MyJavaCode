package mediator.base;

import javax.swing.*;

/**
 * @program: Lear-Java
 * @description: 组员按钮
 * @author: Mr.Dai
 * @create: 2018-10-27 21:09
 **/
public class ColleagueButton extends JButton implements Colleague {

    private  Mediator mediator;

    public ColleagueButton(String text) {
        super(text);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator=mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }
}
