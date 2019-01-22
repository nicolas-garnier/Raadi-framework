package raadi.provider;

import raadi.aspects.AfterInvocation;
import raadi.aspects.AroundInvocation;
import raadi.aspects.BeforeInvocation;

public class Singleton<T> extends AbstractProvider<T> {
    private final T object;

    public Singleton(T tObject) {
        super();
        this.object = tObject;
    }

    public Singleton(T tObject, BeforeInvocation<T> beforeInvocation, AfterInvocation<T> afterInvocation, AroundInvocation aroundInvocation) {
        super(beforeInvocation, afterInvocation, aroundInvocation);
        this.object = tObject;
    }

    @Override
    public T getBean() {
        return object;
    }
}
