package raadi.provider;

import raadi.aspects.AfterInvocation;
import raadi.aspects.AroundInvocation;
import raadi.aspects.BeforeInvocation;

public abstract class AbstractProvider<T> implements Provider<T> {
    BeforeInvocation<T> beforeInvocation;
    AfterInvocation<T> afterInvocation;
    AroundInvocation aroundInvocation;

    public AbstractProvider() {
        this.beforeInvocation = null;
        this.afterInvocation = null;
        this.aroundInvocation = null;
    }

    public AbstractProvider(BeforeInvocation<T> beforeInvocation, AfterInvocation<T> afterInvocation, AroundInvocation aroundInvocation) {
        this.beforeInvocation = beforeInvocation;
        this.afterInvocation = afterInvocation;
        this.aroundInvocation = aroundInvocation;
    }
}
