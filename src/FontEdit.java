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
    JMenu menuColor,menuFont;
    JMenuItem tmpMenuItem;
    public FontEdit(JTextPane jtextPane){
        textPane=jtextPane;
        menuColor = new JMenu("字體顏色");
        addColor("藍色");
        addColor("紅色");
        addColor("粉紅色");
        menuFont = new JMenu("字體");
        addFontStyle("標楷體");
        addFontStyle("微軟正黑體");
        addFontStyle("新細明體");
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
    public void addColor(String newColor){
        tmpMenuItem = new JMenuItem(newColor);
        tmpMenuItem.addActionListener(this);
        menuColor.add(tmpMenuItem);
    }
    public void addFontStyle(String newFontStyle){
        tmpMenuItem = new JMenuItem(newFontStyle);
        tmpMenuItem.addActionListener(this);
        menuFont.add(tmpMenuItem);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();

        if(s.equals("藍色")){
            MutableAttributeSet blueAttr=new SimpleAttributeSet();
            StyleConstants.setForeground(blueAttr, Color.blue);
            setCharacterAttributes(textPane,blueAttr,false);


        }else if(s.equals("粉紅色")){
            MutableAttributeSet yellowAttr=new SimpleAttributeSet();
            StyleConstants.setForeground(yellowAttr,Color.pink);
            setCharacterAttributes(textPane,yellowAttr,false);

        }else if(s.equals("紅色")){
            MutableAttributeSet redAttr=new SimpleAttributeSet();
            StyleConstants.setForeground(redAttr,Color.red);
            setCharacterAttributes(textPane,redAttr,false);
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