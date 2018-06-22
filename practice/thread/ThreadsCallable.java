package thread;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadsCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable1 = new MyCallable("E:\\");
        MyCallable myCallable2 = new MyCallable("C:\\");
        FutureTask<List<String>> f1 = new FutureTask<>(myCallable1);
        FutureTask<List<String>> f2 = new FutureTask<>(myCallable2);
        Thread t1 = new Thread(f1);
        Thread t2 = new Thread(f2);
        t1.start();
        t2.start();
        System.out.println(f1.get());
        System.out.println(f2.get());
        List<String> list1 = f1.get();
        List<String> list2 = f2.get();
        System.out.println("args = [" + args + "]");
//        if (f1.get() || f2.get()) {
//            System.out.println("args = [ok]");
//        }
    }

    static class MyCallable implements Callable<List<String>> {
        @Override
        public List<String> call() {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "--" + i);
            }
            File file = new File(path);
            for (File f :
                    file.listFiles()) {
                if (f.isDirectory()) {
                    System.out.println(f.getName());
                    list.add(f.getName());
                }
            }
            System.out.println("--------------------");
            return list;
        }

        private String path;

        public MyCallable(String path) {
            this.path = path;
        }
    }
}
