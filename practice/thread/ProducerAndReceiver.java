package thread;

/**
 * 生产者和消费者的问题
 */
public class ProducerAndReceiver {
    public static volatile int count;

    public static void main(String[] args) {
        Thread producer1 = new Thread(new Producer(), "Producer1");
        Thread receiver1 = new Thread(new Receiver(), "receiver1");
        producer1.start();
        receiver1.start();

    }
}

// 生产者
class Producer implements Runnable {

    @Override
    public void run() {
        int count = ProducerAndReceiver.count;
        for (int i = 0; i < 100; i++) {
            count++;
            System.out.println("生产者生产了" + count + "个商品");
            // 当生产物品超过50的时候暂时停止
            while (count == 50) {
                try {
                    System.out.println("生产者生产了" + count + "个商品，停止生产");
                    Thread.currentThread().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (count == 0) {
                System.out.println("生产者生产了" + count + "个商品，重新开始生产");
                Thread.currentThread().notify();
            }
        }
    }
}

// 消费者
class Receiver implements Runnable {
    int count = ProducerAndReceiver.count;

    @Override
    public void run() {
//        count--;
//        System.out.println("消费者停止消费，还剩余" + count + "个");
        while (count == 0) {
            try {
                System.out.println("消费者停止消费，还剩余" + count + "个");
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (count > 0) {
            Thread.currentThread().notify();
            System.out.println("消费者消费了1个商品，还剩余" + count + "个");
            count--;
        }
    }
}
