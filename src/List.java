import javax.swing.*;

public class List extends JFrame {
    static StringBuffer Output = new StringBuffer();

    public static Sign BuildSign(String SingType){
        String s = "錯誤";
        if(SingType.equals("圓形"))
            return new CircleSign();
        else
            return new RhombusSign();
    }

    public void print(){
        System.out.println(Output.toString());
    }


}


