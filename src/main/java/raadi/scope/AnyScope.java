package raadi.scope;

import raadi.aspects.AfterInvocation;
import raadi.aspects.AroundInvocation;
import raadi.aspects.BeforeInvocation;
import raadi.provider.AbstractProvider;
import raadi.provider.Provider;
import raadi.provider.Singleton;

import java.util.HashMap;

public class AnyScope<T> {

    protected HashMap<Class<T>, Provider<T>> hashMapProviders;

    public AnyScope() {
        hashMapProviders = new HashMap<>();
    }

    /**
     *      Getter / Setter
     * */
    public HashMap<Class<T>, Provider<T>> getHashMapProviders() {
        return hashMapProviders;
    }

    public void setHashMapProviders(HashMap<Class<T>, Provider<T>> hashMapProviders) {
        this.hashMapProviders = hashMapProviders;
    }

    /**
     *
     * @param tClass
     * @param object
     * @param beforeInvocation
     * @param afterInvocation
     * @param aroundInvocation
     */
    public void bean(Class<T> tClass, T object, BeforeInvocation beforeInvocation, AroundInvocation aroundInvocation, AfterInvocation afterInvocation) {
        Singleton<T> singleton = new Singleton<>(object, beforeInvocation, afterInvocation, aroundInvocation);
        hashMapProviders.put(tClass, singleton);
    }
}
