package homework20240603;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTask {
    // 3. BlockingQueue:
    //Класс Продьюсер - генерирует сообщения в очередь
    //Класс Консьюмер - забирает сообщения из очереди
    //Задача - реализовать класс Consumer, который будет анализировать сообщения в очереди и
    //при входящем сообщении "exit" заканчивать работу.
    //При реализации можно использовать одну из стандартных реализаций BlockingQueue из библиотеки
    //или собственный вариант BlockingQueue.

    static class Producer implements Runnable{

        BlockingQueue<String> queue;
        File file;

        public Producer(BlockingQueue<String> queue, File file) {
            this.queue = queue;
            this.file = file;
        }

        @Override
        public void run() {
            if(file.exists() && file.isFile()){
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    bufferedReader.lines().forEach(line-> {
                        try {
                            queue.put(line);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
                } catch (FileNotFoundException e ) {
                   e.printStackTrace();
                }
            }

            try {
                queue.put("exit");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class Consumer implements Runnable {

        BlockingQueue<String> queue;

        public Consumer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            boolean shouldExit = false;
            while (!shouldExit) {
                try {
                    String data = queue.take();
                    if (!"exit".equals(data)) {
                        System.out.println("Consumer processes: " + data);
                    } else {
                        shouldExit = true;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                queue.put("exit");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        new Thread(new Producer(queue, new File("homework240506/test1/taskNo3.txt"))).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }


}


