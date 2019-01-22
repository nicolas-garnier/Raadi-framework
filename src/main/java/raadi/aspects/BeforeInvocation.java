package raadi.aspects;

import java.lang.reflect.Method;
import java.util.function.Consumer;

public class BeforeInvocation<T> {

    public BeforeInvocation(Method method, Consumer<T> lambda) {
    }
}
