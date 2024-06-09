package homework20240603;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
//Переписать класс ReentrantLockLinkedBlockingQueue (См. код в репозитории) так, чтобы
//очередь была на основе массива (ArrayDeque)
//размер очереди задавался через параметр size в конструкторе
//при попытки положить элемент в заполненную очередь поток-продьюсер ожидал бы освобождение места
public class ReentrantLockLinkedBlockingQueue<T> {


    private int maxSize;
    private Queue<T> queue;
    private ReentrantLock lock = new ReentrantLock(true);

    private Condition condition = lock.newCondition();

    public ReentrantLockLinkedBlockingQueue(int size) {
       queue = new ArrayDeque<>(size);
       this.maxSize = size;
    }

    public void put(T t) {
        lock.lock();
        try {
            if(queue.size() >= this.maxSize) {
                condition.await();
            }
            queue.add(t);
            condition.signal();
        } catch (InterruptedException e) {
           e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.awaitUninterruptibly();
            }
            return queue.poll();
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

}