package homework20240603;

public class UseReentrantLockArrayBlockingQueue {

    static class Producer implements Runnable {
        ReentrantLockArrayBlockingQueue<String> queue;

        public Producer(ReentrantLockArrayBlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                String data = "Data " + i + "-" + Thread.currentThread().getName();
                queue.put(data);
                System.out.println(Thread.currentThread().getName() + " created: " + data);
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }

    static class Consumer implements Runnable {
        ReentrantLockArrayBlockingQueue<String> queue;

        public Consumer(ReentrantLockArrayBlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                String data = queue.take();
                System.out.println(Thread.currentThread().getName() + " processing: " + data + ", queue size: " + queue.size());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockArrayBlockingQueue<String> queue = new ReentrantLockArrayBlockingQueue<>(2);
        Producer producer1 = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer1, "Producer1").start();
        new Thread(consumer, "Consumer").start();
    }

}