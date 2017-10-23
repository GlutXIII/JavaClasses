package pl.lodz.uni.math.SingletonBlue;

public class Single {
    private static Single instance;

    private Integer amount;
    private Single() {
    }

    public static Single getInstanceOf() {
        if (instance == null)
            instance = new Single();
        return instance;
    }

    public static Single getInstance() {
        return instance;
    }

    public static void setInstance(Single instance) {
        Single.instance = instance;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
