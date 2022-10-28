import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFontComponent extends TextFont  {
    JButton italicsButton,bottomlineButton,boldButton;

    public TextFontComponent(JTextPane textPane){
        this.textPane=textPane;
        defineImageButton =new DefineImageButton();
    }

    public MutableAttributeSet changeStyle(){
        StyledEditorKit kit = getStyledEditorKit(textPane);
        MutableAttributeSet attr = kit.getInputAttributes();
        return attr;
    }

}
