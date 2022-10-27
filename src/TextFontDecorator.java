import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.ActionEvent;

abstract class TextFontDecorator extends TextFont{
    TextFontComponent textFontComponent;
    public TextFontDecorator(TextFontComponent textFontComponent){
        this.textFontComponent=textFontComponent;
    }
    public void actionPerformed(ActionEvent e){
        textFontComponent.actionPerformed(e);
    }

    public static final void setCharacterAttributes(JEditorPane editor,
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
    }protected static final StyledEditorKit getStyledEditorKit(JEditorPane e) {
        EditorKit k = e.getEditorKit();
        if (k instanceof StyledEditorKit) {
            return (StyledEditorKit) k;
        }
        throw new IllegalArgumentException("EditorKit must be StyledEditorKit");
    }
    protected static final StyledDocument getStyledDocument(JEditorPane e) {
        Document d = e.getDocument();
        if (d instanceof StyledDocument) {
            return (StyledDocument) d;
        }
        throw new IllegalArgumentException("document must be StyledDocument");
    }

}
