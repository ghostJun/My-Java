package thread;

public class ThreadJoin extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(currentThread().getName() + "在运行");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new ThreadJoin();
        Thread t2 = new ThreadJoin();
        t1.start();
        t1.join(5);
        t2.start();
    }
}
