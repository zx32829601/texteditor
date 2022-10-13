import javax.swing.*;
public class UI extends JFrame{
    public UI(){
        super("新增文字檔案");
        setUpUIComponent();
        setUpEventListener();
        setVisible(true);
    }

    private void setUpEventListener() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setUpUIComponent() {
        setSize(640, 480);
    }

}
