package pl.lodz.uni.math.test;

import pl.lodz.uni.math.SingletonGreen.Single;

public class TestGreenOption {
    public static void testGreen(){
        System.out.println("--------GreenOptionTest-------");
        Single single = Single.getInstance();
        Single single1 = Single.getInstance();
        single.setAmount(1);
        single1.setAmount(2);
        System.out.println("single amount: " +single.getAmount() + " single1 amount: " + single1.getAmount());
    }
}
