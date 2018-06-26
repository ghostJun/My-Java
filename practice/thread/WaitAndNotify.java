package thread;


import java.util.ArrayList;
import java.util.List;

public class WaitAndNotify {
    // 生产者，消费者模型，设定一个最大生产数量num，=num 生产者不生产 <num 生产者生产且消费者也消费
    // 设置最大的商品数
    private static int num = 10;
    // 生产产品数
    private static List<Object> list = new ArrayList<>();

    public static void main(String[] args) {
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());
        producer.start();
        consumer.start();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (list) {
                    // 如果超过最大数量，进行wait，生产者不生产
                    while (list.size() >= num) {
                        try {
                            System.out.println("生产者停止生产:" + list.size());
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.add(new Object());
                    System.out.println("生产者生产1个商品，总商品数:" + list.size());
                    list.notifyAll();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (list) {
                    // 如果超过最大数量，进行wait，生产者不生产
                    while (list.size() == 0) {
                        try {
                            System.out.println("消费者停止消费:" + list.size());
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.remove(0);
                    System.out.println("消费者消费1个商品，总商品数:" + list.size());
                    list.notifyAll();
                }
            }
        }
    }
}


