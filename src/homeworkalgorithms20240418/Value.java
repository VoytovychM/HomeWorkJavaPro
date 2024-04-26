package homeworkalgorithms20240418;


public class Value {
    private int value;
    private Value next;

    public Value(int value){
        this.next = null;
        this.value = value;
    }

    public int getValue() {

        return value;
    }

    public Value getNext() {

        return this.next;
    }

    public void setNext(Value next) {
        this.next = next;
    }
}
