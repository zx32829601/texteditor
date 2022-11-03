package visitor;

import java.lang.reflect.Type;

public interface Visitor {
    Type visit(Find f);
    Type visit(Replace rp);
}
