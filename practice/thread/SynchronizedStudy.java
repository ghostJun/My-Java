package thread;

public class SynchronizedStudy implements Runnable {

    Foo foo = new Foo();

    public int fix(int y) {
        return foo.minus(y);
    }


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            this.fix(30);
            try {
                Thread.sleep(1);
                System.out.println(Thread.currentThread().getName() + "  " + foo.getX());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        SynchronizedStudy synchronizedStudy = new SynchronizedStudy();
        Thread t1 = new Thread(synchronizedStudy, "Thread-A");
        Thread t2 = new Thread(synchronizedStudy, "Thread-B");
        t1.start();
        t2.start();
    }
}
