import java.lang.reflect.Type;

public class Fuc_visitor implements Visitor {
    String text = "";
    public Type visit(Find f){
        f.feature(text);
        return null;
    }
    public Type visit(Replace rp){
        rp.settext(text);
        rp.feature();
        text="";
        return null;
    }
    public void inputtext(String t){
        this.text = t;
    }
    public String getText() {
        return text;
    }
}
