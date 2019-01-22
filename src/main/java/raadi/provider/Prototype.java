package raadi.provider;

import java.util.function.Supplier;

public class Prototype<T> implements Provider {
    public final Supplier<T> supplier;

    public Prototype(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public T getBean() {
        return supplier.get();
    }
}
