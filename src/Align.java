import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Align implements ActionListener {
    JTextPane textPane;
    JButton leftAlignButton, centerButton, rightAlignButton, tmpButton;
    DefineImageButton defineImageButton;
    public Align(JTextPane jtextPane) {
        textPane = jtextPane;
        defineImageButton = new DefineImageButton();
        leftAlignButton = createAlignButton("靠左對齊","leftAlign",defineImageButton.leftalignIcon);
        centerButton = createAlignButton("置中對齊","center",defineImageButton.centerIcon);
        rightAlignButton = createAlignButton("靠右對齊","rightAlign",defineImageButton.rightalignIcon);

    }
    public JButton createAlignButton(String tipText, String functionName, ImageIcon photoName){
        tmpButton = new JButton(photoName);
        tmpButton.setToolTipText(tipText);
        tmpButton.setText(functionName);
        tmpButton.setFont(new Font(functionName, 0, 0));
        tmpButton.addActionListener(this);
        return tmpButton;
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
        if(s.equals("leftAlign")) {
            MutableAttributeSet leftalignattr = new SimpleAttributeSet();
            StyleConstants.setAlignment(leftalignattr, 0);
            setParagraphAttributes(textPane, leftalignattr, false);
        } else if (s.equals("center")) {
            MutableAttributeSet centerattr = new SimpleAttributeSet();
            StyleConstants.setAlignment(centerattr, 1);
            setParagraphAttributes(textPane, centerattr, false);
        }else if (s.equals("rightAlign")){
            MutableAttributeSet rightalignattr = new SimpleAttributeSet();
            StyleConstants.setAlignment(rightalignattr, 2);
            setParagraphAttributes(textPane, rightalignattr, false);
        }
    }
}