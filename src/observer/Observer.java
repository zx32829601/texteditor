package observer;
import javax.swing.*;
import javax.swing.text.Document;

public interface Observer {
    public void calculate(Document document);
    public JLabel getStateBar();
}
