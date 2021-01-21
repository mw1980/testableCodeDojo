package domain;

public abstract class ValueObject<T> {
    private final T value;

    public ValueObject(T value) {
        this.value = value;
    }

    public T value() {
        return this.value;
    }
}
