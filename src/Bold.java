
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zx328
 */
public class Bold extends TextFontDecorator {

    public Bold(JTextPane jtextPane){
        textPane=jtextPane;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();

        if(s.equals("bold")) {
            StyledEditorKit kit = getStyledEditorKit(textPane);
            MutableAttributeSet attr = kit.getInputAttributes();
            boolean bold = (StyleConstants.isBold(attr)) ? false : true;
            SimpleAttributeSet sas = new SimpleAttributeSet();
            StyleConstants.setBold(sas, bold);
            setCharacterAttributes(textPane, sas, false);
        }

    }
}