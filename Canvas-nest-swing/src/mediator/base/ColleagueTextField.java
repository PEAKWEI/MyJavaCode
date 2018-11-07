package mediator.base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * @program: Lear-Java
 * @description: 组员输入�?
 * @author: Mr.Dai
 * @create: 2018-10-27 21:13
 **/
public class ColleagueTextField extends TextField implements Colleague, TextListener {

    private Mediator mediator;

    public ColleagueTextField(String text, int columns) {
        super(text, columns);
    }

    @Override
    public void textValueChanged(TextEvent e) {
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
