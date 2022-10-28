import javax.swing.text.*;


/**
 * @author zx328
 */
public class Italics extends TextFontDecorator {

    public Italics(TextFontComponent textFontComponent) {
        super(textFontComponent);
    }

    public MutableAttributeSet changeStyle() {
        boolean italic = (StyleConstants.isItalic(super.changeStyle())) ? false : true;
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setItalic(sas, italic);
        setCharacterAttributes(super.textFontComponent.textPane, sas, false);
        return null;
    }
}