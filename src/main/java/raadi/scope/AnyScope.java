package raadi.scope;

import raadi.aspects.AfterInvocation;
import raadi.aspects.AroundInvocation;
import raadi.aspects.BeforeInvocation;

public class AnyScope extends Scope {

    @Override
    public void bean(Class aClass, Object object, BeforeInvocation beforeInvocation, AroundInvocation aroundInvocation, AfterInvocation afterInvocation) {

    }
}
