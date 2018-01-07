public class SingletonLazy {
    private static SingletonLazy instance = null;

    private int value;
    private SingletonLazy (Integer something){}
    public static SingletonLazy getInstance(){
        if(instance == null){
            synchronized(SingletonLazy.class){
            if(instance == null){
            instance = new SingletonLazy(Integer.valueOf(7));
        }}}
        return instance;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
