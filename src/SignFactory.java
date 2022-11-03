import javax.swing.*;

public class SignFactory extends JFrame {

    public static Sign BuildSign(String SingType) {
        switch (SingType){
            case "圓形":{
                return new CircleSign();
            }
            case "菱形":{
                return new RhombusSign();
            }

        }
        return null;
        /*if (SingType.equals("圓形"))
            return new CircleSign();
        else
            return new RhombusSign();*/
    }
}



