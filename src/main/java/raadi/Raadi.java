package raadi;

import raadi.provider.Provider;
import raadi.provider.Singleton;
import raadi.scope.AnyScope;

import java.util.HashMap;
import java.util.Stack;
import java.util.function.Consumer;

public class Raadi<T> {

    Stack<AnyScope> stackScope;

    public Raadi()
    {
        stackScope = new Stack<>();
        stackScope.push(new AnyScope<T>());
    }

    public void provider(T tObject, Provider<T> provider)
    {
        AnyScope<T> curr = stackScope.peek();

        HashMap<T, Provider<T>> hm = curr.getHashMapProviders();
        hm.put(tObject, provider);
        curr.setHashMapProviders(hm);
    }


    public void scope(AnyScope<T> scope, Consumer<AnyScope<T>> consumer)
    {
        consumer.accept(scope);
    }

    public <T> T instanceOf(Class<T> tClass) {
        try {
            return tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void bean(Class<T> tClass, T tObject) {
        this.provider(tObject, new Singleton<>(tObject));
    }
}
