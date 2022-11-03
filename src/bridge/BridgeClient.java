package bridge;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.*;

public class BridgeClient implements ActionListener {

    JTextPane textPane;
    JMenu menuHighLighter;
    RefindFontColor fontColor;
    RefindHighLighter highLighterColor;
    ImplementorColor yellow = new ConcreteImplementorYellow();
    ImplementorColor green = new ConcreteImplementorGreen();


    public BridgeClient(JTextPane jtextPane) {
        textPane = jtextPane;
        menuHighLighter = new JMenu("醒目提示");
        highLighterColor = new RefindHighLighter(this.textPane);
        fontColor = new RefindFontColor(this.textPane);

    }

    public JMenu getMenuHighLighter() {
        return menuHighLighter;
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("黃色")) {
            highLighterColor.setImplementorColor(yellow);
            highLighterColor.changeColor();
        } else if (s.equals("綠色")) {
            highLighterColor.setImplementorColor(green);
            highLighterColor.changeColor();

        } else if (s.equals("yello")) {
            fontColor.setImplementorColor(yellow);
            fontColor.changeColor();

        } else if (s.equals("green")) {
            fontColor.setImplementorColor(green);
            fontColor.changeColor();
        }
    }
}
