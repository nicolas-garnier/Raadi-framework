package raadi.provider;

public class Singleton<T> implements Provider {
    private final T object;

    public Singleton(T tObject) {
        this.object = tObject;
    }

    @Override
    public T getBean() {
        return object;
    }
}
