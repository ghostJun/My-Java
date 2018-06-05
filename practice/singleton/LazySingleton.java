package singleton;

/**
 * 懒汉模式
 * 线程不安全
 */
public class LazySingleton {
    private LazySingleton() {
    }

    private static LazySingleton instance = null;

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
