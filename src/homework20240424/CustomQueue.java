package homework20240424;

import java.util.ArrayDeque;

//Переделать класс CustomQueue (пакет lesson20240325.queue) так, чтобы этот класс мог хранить данные любого типа
public class CustomQueue<T> {

    private ArrayDeque<T> deque = new ArrayDeque<>();


    public void enqueue(T data){
        deque.add(data);
    }

    public T dequeue(){
        return deque.removeFirst();
    }

    public static void main(String[] args) {
        CustomQueue<String> myQueue = new CustomQueue<>();
        myQueue.enqueue("A");
        myQueue.enqueue("B");
        myQueue.enqueue("C");

        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());


        CustomQueue<Integer> myQueueInt = new CustomQueue<>();
        myQueueInt.enqueue(1);
        myQueueInt.enqueue(2);
        myQueueInt.enqueue(3);

        System.out.println(myQueueInt.dequeue());
        System.out.println(myQueueInt.dequeue());
        System.out.println(myQueueInt.dequeue());
    }


}

