import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class TextFont implements ActionListener {
    JTextPane textPane;
    DefineImageButton defineImageButton;
    public abstract void actionPerformed(ActionEvent e);
}
