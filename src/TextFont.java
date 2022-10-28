import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class TextFont  {
    JTextPane textPane;
    DefineImageButton defineImageButton;

    public static StyledEditorKit getStyledEditorKit(JEditorPane e) {
        EditorKit k = e.getEditorKit();
        if (k instanceof StyledEditorKit) {
            return (StyledEditorKit) k;
        }
        throw new IllegalArgumentException("EditorKit must be StyledEditorKit");
    }
    public static StyledDocument getStyledDocument(JEditorPane e) {
        Document d = e.getDocument();
        if (d instanceof StyledDocument) {
            return (StyledDocument) d;
        }
        throw new IllegalArgumentException("document must be StyledDocument");
    }
    abstract MutableAttributeSet changeStyle();
}
