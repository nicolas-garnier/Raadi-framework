package raadi.aspects;

import java.lang.reflect.Method;
import java.util.function.Consumer;

public class AfterInvocation<T> {

    public AfterInvocation(Method method, Consumer<T> lambda) {
    }
}
