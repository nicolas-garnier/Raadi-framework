package raadi;

import raadi.provider.Prototype;
import raadi.provider.Singleton;
import raadi.scope.Scope;

import java.util.function.Consumer;

public class Raadi<T> {
    public Raadi()
    {

    }

    public void provider(Object tObject, Singleton<T> singleton)
    {
        // TODO
    }

    public void provider(Object tObject, Prototype<T> prototype)
    {
        // TODO
    }

    public void scope(Scope<T> scope, Consumer<Scope<T>> consumer)
    {

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
    }
}
