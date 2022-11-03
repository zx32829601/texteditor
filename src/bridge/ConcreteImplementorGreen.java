package bridge;

import java.awt.*;
import java.lang.Object;


public class ConcreteImplementorGreen implements ImplementorColor {
    @Override
    public Color getColor(){
        return Color.GREEN;
    }
}
