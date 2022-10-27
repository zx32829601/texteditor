import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zx328
 */
public class Bold extends TextFontDecorator {

    public Bold(TextFontComponent textFontComponent){
        super(textFontComponent);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        boolean bold = (StyleConstants.isBold(attr)) ? false : true;
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setBold(sas, bold);
        setCharacterAttributes(textPane, sas, false);
    }
}