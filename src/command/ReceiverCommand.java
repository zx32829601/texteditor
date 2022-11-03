package command;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;
public class ReceiverCommand extends JFrame{
    JTextPane textPane;
    public void setTextPane(JTextPane textPane) {
        this.textPane = textPane;
    }
    public void cut() {
        textPane.cut();
    }
    public void copy() {
        textPane.copy();
    }
    public void paste() {
        textPane.paste();
    }
    public static final void setCharacterAttributes(JEditorPane editor, AttributeSet attr, boolean replace) {
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
    public void blueFont(){
        MutableAttributeSet blueAttr=new SimpleAttributeSet();
        StyleConstants.setForeground(blueAttr, Color.blue);
        setCharacterAttributes(textPane,blueAttr,false);
    }
    public void pinkFont(){
        MutableAttributeSet yellowAttr=new SimpleAttributeSet();
        StyleConstants.setForeground(yellowAttr,Color.pink);
        setCharacterAttributes(textPane,yellowAttr,false);
    }
    public void redFont(){
        MutableAttributeSet redAttr=new SimpleAttributeSet();
        StyleConstants.setForeground(redAttr,Color.red);
        setCharacterAttributes(textPane,redAttr,false);
    }
    public void fontStyleOne(){
        MutableAttributeSet standardAttr = new SimpleAttributeSet();
        StyleConstants.setFontFamily(standardAttr,"標楷體");
        setCharacterAttributes(textPane,standardAttr,false);
    }
    public void fontStyleTwo(){
        MutableAttributeSet microsoftBoldAttr =new SimpleAttributeSet();
        StyleConstants.setFontFamily(microsoftBoldAttr,"微軟正黑體");
        setCharacterAttributes(textPane,microsoftBoldAttr,false);
    }
    public void fontStyleThree(){
        MutableAttributeSet newDetailAttr =new SimpleAttributeSet();
        StyleConstants.setFontFamily(newDetailAttr,"新細明體");
        setCharacterAttributes(textPane,newDetailAttr,false);
    }
}
