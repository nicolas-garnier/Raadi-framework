package raadi.aspects;

import java.lang.reflect.Method;

public class ExecutionContext {
    public Method method;

    public Object proceed() {
        return new Object();
    }
}
