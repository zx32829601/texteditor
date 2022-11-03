package factory;

public interface Sign {
    StringBuffer Output = new StringBuffer();
    StringBuffer doc = new StringBuffer();
    void Input(String input_text, Boolean state);

    String Changed_text();


}
