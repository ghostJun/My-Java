package singleton;

public class HungarySingleton {
    private HungarySingleton() {
    }

    private static HungarySingleton instance = new HungarySingleton();

    public static HungarySingleton getInstance() {
        return instance;
    }
}
