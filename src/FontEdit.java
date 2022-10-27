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
    ReceiverCommand receiver;
    InvokerCommand invoker;
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
        receiver = new ReceiverCommand();
        invoker = new InvokerCommand();
        receiver.setTextPane(textPane);
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
            Command blueFont = new BlueFontCommand(receiver);
            invoker.addCommend(blueFont);
            invoker.execute();
        }else if(s.equals("粉紅色")){
            Command pinkFont = new PinkFontCommand(receiver);
            invoker.addCommend(pinkFont);
            invoker.execute();
        }else if(s.equals("紅色")){
            Command redFont = new RedFontCommand(receiver);
            invoker.addCommend(redFont);
            invoker.execute();
        }else if(s.equals("標楷體")){
            Command fontStyleOne = new FontStyleOneCommand(receiver);
            invoker.addCommend(fontStyleOne);
            invoker.execute();
        }else if(s.equals("微軟正黑體")){
            Command fontStyleTwo = new FontStyleTwoCommand(receiver);
            invoker.addCommend(fontStyleTwo);
            invoker.execute();
        }else if(s.equals("新細明體")){
            Command fontStyleThree = new FontStyleThreeCommand(receiver);
            invoker.addCommend(fontStyleThree);
            invoker.execute();
        }


    }
}