import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RefindFontColor extends AbstractionFont  {
    public String getName() {
        return "Backpack";
    }

    public void fontColor(JTextPane textPane) {
        MutableAttributeSet redAttr=new SimpleAttributeSet();
        StyleConstants.setForeground(redAttr,this.color);
        setCharacterAttributes(textPane,redAttr,false);
    }

}

