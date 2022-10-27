import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zx328
 */
public class Bottomline extends TextFontDecorator{

    public Bottomline(TextFontComponent textFontComponent){
        super(textFontComponent);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        boolean underline = (StyleConstants.isUnderline(attr)) ? false : true;
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setUnderline(sas, underline);
        setCharacterAttributes(textPane, sas, false);
    }
}