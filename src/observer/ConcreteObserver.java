package observer;
import javax.swing.*;
import javax.swing.text.Document;
public class ConcreteObserver implements Observer{

    static JLabel stateBar;
    public ConcreteObserver(){
        createWordCount();
    }

    public  JLabel getStateBar() {
        return stateBar;
    }

    public void createWordCount(){
        stateBar = new JLabel("Characters:" + 0);
        stateBar.setHorizontalAlignment(SwingConstants.LEFT);


    }
    @Override
    public void calculate(Document document) {
        int count=document.getLength();
        System.out.println(count);
        stateBar.setText("Characters:"+count);

    }
}
