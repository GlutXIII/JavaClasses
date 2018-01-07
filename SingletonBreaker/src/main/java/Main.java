
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        SingletonLazy singleton = SingletonLazy.getInstance();
        Constructor constructor = singleton.getClass().getDeclaredConstructor(new Class[0]);
        constructor.setAccessible(true);
        SingletonLazy singleton2 = (SingletonLazy) constructor.newInstance();
        if (singleton == singleton2) {
            System.out.println("Two objects are same");
        } else {
            System.out.println("Two objects are not same");
        }
        singleton.setValue(1);
        singleton2.setValue(2);
        System.out.println(singleton.getValue());
        System.out.println(singleton2.getValue());
    }
}

