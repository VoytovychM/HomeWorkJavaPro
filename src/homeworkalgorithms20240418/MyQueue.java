package homeworkalgorithms20240418;

public class MyQueue {
    private int maxsize = 10;
    private int[] queueArray;
    private int head;
    private int tail;
    private int numberOfValues;

    public MyQueue() {
        queueArray = new int[maxsize];
        head = 0;
        tail = -1;
        numberOfValues = 0;
    }

    public void push(int v) {
        if (numberOfValues == maxsize) {
            System.out.println("Queue is full");
            return;
        }
        tail = (tail + 1) % maxsize;
        queueArray[tail] = v;
        numberOfValues++;
    }

    public int pop() {
        if (numberOfValues == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        int removedValue = queueArray[head];
        head = (head + 1) % maxsize;
        numberOfValues--;
        return removedValue;
    }

    public boolean isEmpty() {
        return numberOfValues == 0;
    }



    public static void main(String[] args) {
       MyQueue myQueue = new MyQueue();
       myQueue.push(10);
       myQueue.push(50);
       myQueue.push(20);
       System.out.println(myQueue);
       System.out.println(myQueue.pop());
       System.out.println(myQueue.pop());
       System.out.println(myQueue.pop());
       System.out.println(myQueue.pop());
        System.out.println(myQueue.isEmpty());
    }
        }


