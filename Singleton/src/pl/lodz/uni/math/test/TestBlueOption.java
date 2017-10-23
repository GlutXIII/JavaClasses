package pl.lodz.uni.math.test;

import pl.lodz.uni.math.SingletonBlue.Single;

public class TestBlueOption {
    public static void testBlue(){
        System.out.println("--------BlueOptionTest-------");
        Single single = Single.getInstanceOf();
        Single single1 = Single.getInstanceOf();
        single.setAmount(1);
        single1.setAmount(2);
        System.out.println("single amount: " +single.getAmount() + " single1 amount: " + single1.getAmount());
    }
}
