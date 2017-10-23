package pl.lodz.uni.math.SingletonGreen;

public class Single{
    private static Single instance = new Single();

    private Integer amount;
    private Single() {
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
