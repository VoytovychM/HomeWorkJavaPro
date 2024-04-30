package homeworkalgorithm20240425;

import org.w3c.dom.Node;

public class MyLinkedList {

    private static class Link {
        private final int value;
        private Link next;

        public Link(int value) {
            this.value = value;
            this.next = null;
        }

        public Link(int value, Link next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public Link getNext() {
            return next;
        }

        public boolean hasNext() {
            return next != null;
        }

        public void setNext(Link p) {
            this.next = p;
        }
    }

    private Link head = null;

    public void pushToHead(int v) {
        Link nextHead = new Link(v, head);
        head = nextHead;
    }

    public void pushToTail(int value) {
        if (head == null) {
            pushToHead(value);
        } else {
            Link curLink = head;

            while (curLink.getNext() != null)
                curLink = curLink.getNext();

            curLink.setNext(new Link(value, null));
        }
    }

    public void pushToIndex(int index, int value) {
        Link curLink = head;

        for (int i = 0; i < index -1 ; i++) {
            curLink = curLink.getNext();
        }
        curLink.setNext(new Link(value, curLink.getNext()));
    }

    public void removeFirst() {
       head = head.getNext();
    }

    public void removeLast() {

            Link curLink = head;
            Link prevLink = null;
            while (curLink.getNext() != null) {
                prevLink = curLink;
                curLink = curLink.getNext();

            }
            prevLink.setNext(null);


    }

    public void removeAtIndex(int index) {
        Link prevLink = head;

        for (int i = 0; i < index -1; i++) {
            prevLink = prevLink.getNext();
        }
        Link nextLink = head;
        for (int i = 0; i < index + 1 ; i++) {
            nextLink = nextLink.getNext();
        }
        if(nextLink != null){
            prevLink.setNext(nextLink);
        }

    }


    public int getByIndex(int index) {
        Link curLink = head;

        int i = 0;
        for (; i < index; i++) {
            curLink = curLink.getNext();
        }

        return curLink.getValue();
    }

    public int getIndexByValue(int value) {
        int index = 0;
        Link curLink = head;

        while (curLink != null) {
            if (curLink.getValue() == value)
                return index;
            curLink = curLink.getNext();
            index++;
        }
        // не нашли
        return -1;
    }

    public int size() {
        int i = 0;
        Link curLink = head;
        while (curLink != null) {
            i++;
            curLink = curLink.getNext();
        }
        return i;
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        if (size() == 0) {
            result.append("<empty>");
        } else {
            result.append("|-> ").append(head.value);
            Link current = head.getNext();
            while (current != null) {
                result.append(", ").append(current.getValue());
                current = current.getNext();
            }
        }
        return result.toString();
    }
     // Task No.2
    public int getValueFromTail(int positionFromTail) {
        int revertedIndex = size() -1 - positionFromTail;
        return this.getByIndex(revertedIndex);

    }
    // TaskNo.3

    boolean hasLoop(){
         if(head == null || head.next == null){
            return false;

         }
       Link a = head;
       Link b = head.next;

       while (b != null && b.next != null ){
           if(a==b){
              return true;
           }
           a = a.next;
           b = b.next.next;
       }

       return false;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        System.out.println(list.print());

        list.pushToHead(10);
        list.pushToHead(20);
        list.pushToHead(30);
        list.pushToTail(40);

        System.out.println(list.print());

        System.out.println("15 at: " + list.getIndexByValue(15));
        System.out.println("20 at: " + list.getIndexByValue(20));
        list.pushToIndex(3, 4);
        System.out.println(list.getByIndex(3));

        System.out.println(list.getByIndex(2));
        list.removeLast();
        System.out.println(list.getByIndex(2));
        list.removeAtIndex(2);
        System.out.println(list.getByIndex(2));
        System.out.println(list.getValueFromTail(0));
        list.hasLoop();
        System.out.println(list);



    }
}