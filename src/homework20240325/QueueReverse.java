package homework20240325;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReverse{

         // Имеется очередь Queue. Написать метод, возвращающий очередь Queue, в которой элементы расположены в обратном порядке.

    public static Queue<Integer> reverseQueue(Queue<Integer> originalQueue) {
        // Создаем стек для временного хранения элементов
        Stack<Integer> stack = new Stack<>();

        // Переносим элементы из очереди в стек
        while (!originalQueue.isEmpty()) {
            stack.push(originalQueue.poll());
        }

        // Создаем новую очередь для хранения элементов в обратном порядке
        Queue<Integer> reversedQueue = new LinkedList<>();

        // Переносим элементы из стека в новую очередь
        while (!stack.isEmpty()) {
            reversedQueue.offer(stack.pop());
        }

        return reversedQueue;
    }

    public static void main(String[] args) {
        // Пример использования метода
        Queue<Integer> originalQueue = new LinkedList<>();
        originalQueue.offer(1);
        originalQueue.offer(2);
        originalQueue.offer(3);
        originalQueue.offer(4);

        Queue<Integer> reversedQueue = reverseQueue(originalQueue);

        // Выводим элементы новой очереди
        while (!reversedQueue.isEmpty()) {
            System.out.print(reversedQueue.poll() + " ");
        }
    }
}