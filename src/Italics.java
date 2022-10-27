import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zx328
 */
public class Italics extends TextFontDecorator  {

    public Italics(TextFontComponent textFontComponent){
        super(textFontComponent);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        boolean italic = (StyleConstants.isItalic(attr)) ? false : true;
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setItalic(sas, italic);
        setCharacterAttributes(textPane, sas, false);
    }
}