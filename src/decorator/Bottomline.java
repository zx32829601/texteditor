package decorator;

import javax.swing.text.*;

public class Bottomline extends TextFontDecorator {

    public Bottomline(TextFont textFont) {
        super(textFont);
    }

    public MutableAttributeSet changeStyle() {
        boolean underline = (StyleConstants.isUnderline(super.changeStyle())) ? false : true;
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setUnderline(sas, underline);
        setCharacterAttributes(super.textFont.textPane, sas, false);
        return null;
    }
}

