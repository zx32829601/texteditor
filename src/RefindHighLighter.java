import javax.swing.*;
import javax.swing.text.*;

class RefindHighLighter extends AbstractionFont  {

    public String getName() {
        return "Backpack";
    }

    StyleContext context = new StyleContext();
    StyledDocument document = new DefaultStyledDocument(context);
    public void highLighterColor(JTextPane textPane) {
        MutableAttributeSet redAttr=new SimpleAttributeSet();
        StyleConstants.setBackground(redAttr,this.color);
        setCharacterAttributes(textPane,redAttr,false);
    }
}
