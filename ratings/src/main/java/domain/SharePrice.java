package domain;

public class SharePrice extends ValueObject<Double> {

    protected SharePrice(Double value) {
        super(value);
    }

    public static SharePrice euro(Double price) {
        return new SharePrice(price);
    }
}
