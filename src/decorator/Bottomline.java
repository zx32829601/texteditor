package decorator;

import javax.swing.text.*;


/**
 * @author zx328
 */
public class Bottomline extends TextFontDecorator {

    public Bottomline(TextFontComponent textFontComponent) {
        super(textFontComponent);
    }

    public MutableAttributeSet changeStyle() {
        boolean underline = (StyleConstants.isUnderline(super.changeStyle())) ? false : true;
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setUnderline(sas, underline);
        setCharacterAttributes(super.textFontComponent.textPane, sas, false);
        return null;
    }
}