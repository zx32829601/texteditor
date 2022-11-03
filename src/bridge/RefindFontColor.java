package bridge;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RefindFontColor extends AbstractionFont  {


    public RefindFontColor(JTextPane textPane) {
        super(textPane);
    }
    @Override
    public void changeColor() {
        MutableAttributeSet redAttr=new SimpleAttributeSet();
        StyleConstants.setForeground(redAttr,implementorColor.getColor());
        setCharacterAttributes(textPane,redAttr,false);
    }
}

