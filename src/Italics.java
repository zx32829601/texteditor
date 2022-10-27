import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zx328
 */
public class Italics extends TextFontDecorator  {

    public Italics(JTextPane jtextPane){
        textPane=jtextPane;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();

        if(s.equals("italics")) {
            StyledEditorKit kit = getStyledEditorKit(textPane);
            MutableAttributeSet attr = kit.getInputAttributes();
            boolean italic = (StyleConstants.isItalic(attr)) ? false : true;
            SimpleAttributeSet sas = new SimpleAttributeSet();
            StyleConstants.setItalic(sas, italic);
            setCharacterAttributes(textPane, sas, false);
        }

    }
}