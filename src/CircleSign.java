import javax.swing.*;

public class CircleSign implements Sign {
    static StringBuffer Output = new StringBuffer();
    static String text;
    static boolean stat;

    public void BuildSign(String input_text, Boolean state){
        JTextPane textPane = new JTextPane();
        StringBuffer doc = new StringBuffer();
        String ip[];
        ip = input_text.split("\n");
        if (state) {
            Output.setLength(0);
            for(int i = 0;i<ip.length;i++){
                doc.append(ip[i]);
                doc.insert(0,"● ");
                Output.append(doc);
                Output.append("\n");
                doc.setLength(0);
            }
        }else {
            Output.setLength(0);
            for(int i = 0;i<ip.length;i++) {
                doc.append(ip[i]);
                doc.replace(0,2,"");
                Output.append(doc);
                Output.append("\n");
                doc.setLength(0);
            }

        }
    }
    public String Changed_text(){
        return Output.toString();
    }
}
