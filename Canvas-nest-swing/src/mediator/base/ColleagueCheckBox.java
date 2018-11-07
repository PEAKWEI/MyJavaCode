package mediator.base;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @program: Lear-Java
 * @description: 组员复�?�框
 * @author: Mr.Dai
 * @create: 2018-10-27 21:15
 **/
public class ColleagueCheckBox extends JRadioButton implements ItemListener,Colleague {

    private Mediator mediator;

    public ColleagueCheckBox(String text, boolean selected) {
        super(text, selected);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        mediator.colleagueChanged();
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
