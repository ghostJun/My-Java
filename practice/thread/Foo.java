package thread;

public class Foo {
    private int x = 100;

    public int getX() {
        synchronized(this) {
            return x;
        }
    }

    public  int minus(int y) {
        x = x - y;
        return x;
    }
}
