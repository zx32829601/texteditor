import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFontComponent extends TextFont  {
    JButton italicsButton,bottomlineButton,boldButton;

    public TextFontComponent(JTextPane textPane){
        this.textPane=textPane;
        createButton();
    }
    public void createButton(){
        //斜體
        italicsButton = new JButton(defineImageButton.italicsIcon);
        italicsButton.setToolTipText("斜體");
        italicsButton.setText("italics");
        italicsButton.setFont(new Font("italics", 0, 0));
        italicsButton.addActionListener(this);
        //底線
        bottomlineButton = new JButton(defineImageButton.bottomlineIcon);
        bottomlineButton.setToolTipText("底線");
        bottomlineButton.setText("bottomline");
        bottomlineButton.setFont(new Font("bottomline", 0, 0));
        bottomlineButton.addActionListener(this);
        //粗體
        boldButton = new JButton(defineImageButton.boldIcon);
        boldButton.setToolTipText("粗體");
        boldButton.setText("bold");
        boldButton.setFont(new Font("bold",0,0));
        boldButton.addActionListener(this);
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
        }else if(s.equals("bottomline")) {
            StyledEditorKit kit = getStyledEditorKit(textPane);
            MutableAttributeSet attr = kit.getInputAttributes();
            boolean underline = (StyleConstants.isUnderline(attr)) ? false : true;
            SimpleAttributeSet sas = new SimpleAttributeSet();
            StyleConstants.setUnderline(sas, underline);
            setCharacterAttributes(textPane, sas, false);
        }else if(s.equals("italics")) {
            StyledEditorKit kit = getStyledEditorKit(textPane);
            MutableAttributeSet attr = kit.getInputAttributes();
            boolean italic = (StyleConstants.isItalic(attr)) ? false : true;
            SimpleAttributeSet sas = new SimpleAttributeSet();
            StyleConstants.setItalic(sas, italic);
            setCharacterAttributes(textPane, sas, false);
        }
    }
}
