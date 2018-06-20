package thread;

import java.util.concurrent.*;

public class ThreadCallable {
    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> result = new FutureTask<>(myCallable);
//        ExecutorService exec = Executors.newFixedThreadPool(5);
        Thread thread1 = new Thread(result);
        Thread thread2 = new Thread(result);
        thread1.start();
        thread2.start();
        try {
            String sum = result.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class MyCallable implements Callable<String> {
        @Override
        public String call() {
//            Integer sum = 0;
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "--" + i);
            }
            return "OK";
        }
    }
}
