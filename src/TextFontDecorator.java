import javax.swing.*;
import javax.swing.text.*;


abstract class TextFontDecorator extends TextFont{
    TextFontComponent textFontComponent;
    public TextFontDecorator(TextFontComponent textFontComponent){
        this.textFontComponent=textFontComponent;
    }

    public MutableAttributeSet changeStyle(){
        return textFontComponent.changeStyle();

    }
    public static void setCharacterAttributes(JEditorPane editor,
                                                    AttributeSet attr, boolean replace) {
        int p0 = editor.getSelectionStart();
        int p1 = editor.getSelectionEnd();
        if (p0 != p1) {
            StyledDocument doc = getStyledDocument(editor);
            doc.setCharacterAttributes(p0, p1 - p0, attr, replace);
        }
        StyledEditorKit k = getStyledEditorKit(editor);
        MutableAttributeSet inputAttributes = k.getInputAttributes();
        if (replace) {
            inputAttributes.removeAttributes(inputAttributes);
        }
        inputAttributes.addAttributes(attr);
    }

}
