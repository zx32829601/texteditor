package decorator;

import javax.swing.text.*;


/**
 * @author zx328
 */
public class Bold extends TextFontDecorator {

    public Bold(TextFontComponent textFontComponent) {
        super(textFontComponent);
    }

    public MutableAttributeSet changeStyle() {
        boolean bold = (StyleConstants.isBold(super.changeStyle())) ? false : true;
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setBold(sas, bold);
        setCharacterAttributes(super.textFontComponent.textPane, sas, false);
        return null;
    }
}