import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Align implements ActionListener {

    UI ui;
    JTextPane textPane;
    JButton leftAlignButton, centerButton, rightAlignButton, tmpButton;
    DefineImageButton defineImageButton;
    public Align(UI ui,JTextPane jtextPane) {
        this.ui=ui;
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
        Context context1 =new  Context(new LeftAlign(this.ui));
        Context context2 =new  Context(new Center(this.ui));
        Context context3 =new  Context(new RightAlign(this.ui));
        if(s.equals("leftAlign")) {
            context1.setAlign();
        } else if (s.equals("center")) {
            context2.setAlign();
        }else if (s.equals("rightAlign")){
            context3.setAlign();
        }
    }
}
class Context {
    private final Strategy strategy;
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public void setAlign() {
        this.strategy.setAlign();
    }
}
interface Strategy{
    void setAlign();
}
class LeftAlign implements Strategy{
    UI ui;
    public LeftAlign(UI ui){this.ui=ui;}
    @Override
    public void setAlign(){
        MutableAttributeSet leftalignattr = new SimpleAttributeSet();
        StyleConstants.setAlignment(leftalignattr, 0);
        Align.setParagraphAttributes(ui.textPane, leftalignattr, false);
    }
}
class Center implements Strategy{
    UI ui;
    public Center(UI ui){this.ui=ui;}
    @Override
    public void setAlign(){
        MutableAttributeSet centerattr = new SimpleAttributeSet();
        StyleConstants.setAlignment(centerattr, 1);
        Align.setParagraphAttributes(ui.textPane, centerattr, false);
    }
}
class RightAlign implements Strategy{
    UI ui;
    public RightAlign(UI ui){this.ui=ui;}
    @Override
    public void setAlign(){
        MutableAttributeSet rightalignattr = new SimpleAttributeSet();
        StyleConstants.setAlignment(rightalignattr, 2);
        Align.setParagraphAttributes(ui.textPane, rightalignattr, false);
    }
}