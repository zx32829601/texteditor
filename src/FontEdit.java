import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zx328
 */
public class FontEdit implements ActionListener {

    JTextPane textPane;

    public FontEdit(JTextPane jtextPane) {
        textPane = jtextPane;
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

        if (s.equals("藍色")) {
            MutableAttributeSet blue_Attr = new SimpleAttributeSet();
            StyleConstants.setForeground(blue_Attr, Color.blue);
            setCharacterAttributes(textPane, blue_Attr, false);


        } else if (s.equals("粉紅色")) {
            MutableAttributeSet yellowAttr = new SimpleAttributeSet();
            StyleConstants.setForeground(yellowAttr, Color.pink);
            setCharacterAttributes(textPane, yellowAttr, false);

        } else if (s.equals("紅色")) {
            MutableAttributeSet redAttr = new SimpleAttributeSet();
            StyleConstants.setForeground(redAttr, Color.red);
            setCharacterAttributes(textPane, redAttr, false);
        }else if(s.equals("標楷體")){
            MutableAttributeSet standardAttr = new SimpleAttributeSet();
            StyleConstants.setFontFamily(standardAttr,"標楷體");
            setCharacterAttributes(textPane,standardAttr,false);
        }else if(s.equals("微軟正黑體")){
            MutableAttributeSet microsoftBoldAttr =new SimpleAttributeSet();
            StyleConstants.setFontFamily(microsoftBoldAttr,"微軟正黑體");
            setCharacterAttributes(textPane,microsoftBoldAttr,false);
        }else if(s.equals("新細明體")){
            MutableAttributeSet newDetailAttr =new SimpleAttributeSet();
            StyleConstants.setFontFamily(newDetailAttr,"新細明體");
            setCharacterAttributes(textPane,newDetailAttr,false);
        }


    }
}