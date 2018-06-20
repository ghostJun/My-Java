package thread;

import java.io.File;
import java.util.concurrent.*;

public class ThreadsCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable1 = new MyCallable("E:\\");
        MyCallable myCallable2 = new MyCallable("C:\\");
        FutureTask<Boolean> f1 = new FutureTask<>(myCallable1);
        FutureTask<Boolean> f2 = new FutureTask<>(myCallable2);
        Thread t1 = new Thread(f1);
        Thread t2 = new Thread(f2);
        t1.start();
        t2.start();
        System.out.println(f1.get());
        System.out.println(f2.get());
        if (f1.get() || f2.get()) {
            System.out.println("args = [ok]");
        }
    }

    static class MyCallable implements Callable<Boolean> {
        @Override
        public Boolean call() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "--" + i);
            }
            File file = new File(path);
            for (File f :
                    file.listFiles()) {
                if (f.isDirectory()) {
                    System.out.println(f.getName());
                }
            }
            System.out.println("--------------------");
            return true;
        }

        private String path;

        public MyCallable(String path) {
            this.path = path;
        }
    }
}
