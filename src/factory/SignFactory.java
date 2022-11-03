package factory;

import javax.swing.*;

public class SignFactory extends JFrame {

    public static Sign BuildSign(String SingType) {
        if (SingType.equals("圓形"))
            return new CircleSign();
        else
            return new RhombusSign();
    }
}



