package observer;

import javax.swing.event.DocumentEvent;

public interface ItDocument {
    public void registerObservers(Observer observer);
    public void removeObservers(Observer observer);
    public void notifyObserver(DocumentEvent e);

}
