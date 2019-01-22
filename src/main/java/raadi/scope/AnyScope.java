package raadi.scope;

import raadi.aspects.AfterInvocation;
import raadi.aspects.AroundInvocation;
import raadi.aspects.BeforeInvocation;
import raadi.provider.Provider;

import java.util.HashMap;

public class AnyScope<T> {

    protected HashMap<T, Provider<T>> hashMapProviders;

    public AnyScope()
    {
        hashMapProviders = new HashMap<>();
    }

    public void bean(Class<T> tClass,
                              T object,
                              BeforeInvocation beforeInvocation,
                              AroundInvocation aroundInvocation,
                              AfterInvocation afterInvocation)
    {
        
    }

    public HashMap<T, Provider<T>> getHashMapProviders() {
        return hashMapProviders;
    }

    public void setHashMapProviders(HashMap<T, Provider<T>> hashMapProviders) {
        this.hashMapProviders = hashMapProviders;
    }
}
