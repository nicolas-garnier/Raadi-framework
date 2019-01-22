package raadi.aspects;

import java.lang.reflect.Method;
import java.util.function.Function;

public class AroundInvocation<T, R> {
    public AroundInvocation(Method method, Function<T, R> function) {
    }
}
