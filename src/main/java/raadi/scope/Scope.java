package raadi.scope;

import raadi.aspects.AfterInvocation;
import raadi.aspects.AroundInvocation;
import raadi.aspects.BeforeInvocation;

public abstract class Scope<T> {

    public abstract void bean(Class<T> tClass,
                              T object,
                              BeforeInvocation beforeInvocation,
                              AroundInvocation aroundInvocation,
                              AfterInvocation afterInvocation);
}
