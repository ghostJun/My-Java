package thread;

/**
 * 指定Thread执行顺序(T1,T2完成后执行T3)
 */
public class ThreadAsc implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + "|" + i);
        }
    }

    private Thread mainThread;

    public ThreadAsc(Thread mainThread) {
        this.mainThread = mainThread;
    }

    public ThreadAsc() {
    }

    public static void main(String[] args) {
        // 不用按顺序执行的t1,t2,t3
        Thread t1 = new Thread(new ThreadAsc(), "t1");
        Thread t2 = new Thread(new ThreadAsc(), "t2");
        Thread t3 = new Thread(new ThreadAsc(), "t3");
//        t1.start();
//        t2.start();
//        t3.start();
        // lambda表达式
        Thread T1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName() + "|" + i);
            }
        }, "T1");
        Thread T2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
//                    T1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                for (int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getName() + "|" + i);
                }
            }
        }, "T2");
        Thread T3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    T2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getName() + "|" + i);
                }
            }
        }, "T3");
        T3.start();
        T1.start();
        T2.start();


    }
}
