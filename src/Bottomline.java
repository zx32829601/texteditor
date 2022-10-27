import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zx328
 */
public class Bottomline extends TextFontDecorator{

    public Bottomline(JTextPane jtextPane){
        textPane=jtextPane;


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();

        if(s.equals("bottomline")) {
            StyledEditorKit kit = getStyledEditorKit(textPane);
            MutableAttributeSet attr = kit.getInputAttributes();
            boolean underline = (StyleConstants.isUnderline(attr)) ? false : true;
            SimpleAttributeSet sas = new SimpleAttributeSet();
            StyleConstants.setUnderline(sas, underline);
            setCharacterAttributes(textPane, sas, false);
        }
    }
}