public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton() {};

    public static synchronized Singleton getInstance(){
        synchronized (Singleton.class) {
            if (uniqueInstance == null) {
                uniqueInstance = new Singleton();
            }
        }
        return uniqueInstance;
    }

    // other code here ...
}
