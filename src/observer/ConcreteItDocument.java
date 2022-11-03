package observer;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ConcreteItDocument implements ItDocument, DocumentListener {
    JTextPane textPane;
    public ConcreteItDocument(JTextPane textPane) {
        this.textPane=textPane;
        textPane.getDocument().addDocumentListener(this);
    }

    private Observer observer;
    @Override
    public void registerObservers(Observer observer) {
        this.observer=observer;

    }

    @Override
    public void removeObservers(Observer observer) {

    }

    @Override
    public void notifyObserver(DocumentEvent e) {
        javax.swing.text.Document document=e.getDocument();
    observer.calculate(document);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        notifyObserver(e);

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        notifyObserver(e);

    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        notifyObserver(e);

    }
}
