package bridge;

import javax.swing.*;
import javax.swing.text.*;

class RefindHighLighter extends AbstractionFont  {


    public RefindHighLighter(JTextPane textPane) {
        super(textPane);
    }


    @Override
    public void changeColor() {
        MutableAttributeSet redAttr=new SimpleAttributeSet();
        StyleConstants.setBackground(redAttr,implementorColor.getColor());
        setCharacterAttributes(textPane,redAttr,false);
    }
}
