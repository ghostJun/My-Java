package thread;

public class ThreadRunnable {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 30) {
                Runnable myRunnableDemo = new MyRunnableDemo();
                Thread thread = new MyThreadDemo(myRunnableDemo);
                thread.start();
            }
        }
    }
}

class MyRunnableDemo implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        System.out.println("in MyRunnable run");
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

class MyThreadDemo extends Thread {
    private int i = 0;

    public MyThreadDemo(Runnable runnable) {
        super(runnable);
    }

    @Override
    public void run() {
        System.out.println("in MyThread run");
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
