import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Align implements ActionListener {
    JTextPane textPane;

    public Align(JTextPane jtextPane) {
        textPane = jtextPane;
    }

    public static final void setParagraphAttributes(JEditorPane editor,
                                                    AttributeSet attr, boolean replace) {
        int p0 = editor.getSelectionStart();
        int p1 = editor.getSelectionEnd();
        StyledDocument doc = getStyledDocument(editor);
        doc.setParagraphAttributes(p0, p1 - p0, attr, replace);
    }


    protected static final StyledEditorKit getStyledEditorKit(JEditorPane e) {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("leftalign")) {
            MutableAttributeSet leftalignattr = new SimpleAttributeSet();
            StyleConstants.setAlignment(leftalignattr, 0);
            setParagraphAttributes(textPane, leftalignattr, false);
        } else if (s.equals("center")) {
            MutableAttributeSet centerattr = new SimpleAttributeSet();
            StyleConstants.setAlignment(centerattr, 1);
            setParagraphAttributes(textPane, centerattr, false);
        }else if (s.equals("rightalign")){
            MutableAttributeSet rightalignattr = new SimpleAttributeSet();
            StyleConstants.setAlignment(rightalignattr, 21);
            setParagraphAttributes(textPane, rightalignattr, false);
        }
    }
}