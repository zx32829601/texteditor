package decorator;

import image.DefineImageButton;

import javax.swing.*;
import javax.swing.text.*;

public class TextFontComponent extends TextFont  {

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
