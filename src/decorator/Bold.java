package decorator;

import javax.swing.text.*;

public class Bold extends TextFontDecorator {

    public Bold(TextFont textFont) {
        super(textFont);
    }

    public MutableAttributeSet changeStyle() {
        boolean bold = (StyleConstants.isBold(super.changeStyle())) ? false : true;
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setBold(sas, bold);
        setCharacterAttributes(super.textFont.textPane, sas, false);
        return null;
    }
}

