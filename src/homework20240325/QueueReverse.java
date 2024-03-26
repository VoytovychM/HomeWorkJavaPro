package homework20240325;

import java.util.LinkedList;
import java.util.Queue;

public class QueueReverse{

         // Имеется очередь Queue. Написать метод, возвращающий очередь Queue, в которой элементы расположены в обратном порядке.

    static Queue<Integer> queue;
    static void print(){
        while (!queue.isEmpty()){
            System.out.println(queue.peek() + " ");
            queue.remove();
        }
    }

    public static Queue<Integer> reverseQueue (Queue<Integer> queueList){
        if (queueList.isEmpty())
            return queueList;
            int data = queueList.peek();
            queueList.remove();
            queueList = reverseQueue(queueList);
            queueList.add(data);
            return queueList;
        }

    public static void main(String[] args) {

        queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue = reverseQueue(queue);
        print();
    }
}
