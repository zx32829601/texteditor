package decorator;

import javax.swing.text.*;

public class Italics extends TextFontDecorator {

    public Italics(TextFont textFont) {
        super(textFont);
    }

    public MutableAttributeSet changeStyle() {
        boolean italic = (StyleConstants.isItalic(super.changeStyle())) ? false : true;
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setItalic(sas, italic);
        setCharacterAttributes(super.textFont.textPane, sas, false);
        return null;
    }
}

