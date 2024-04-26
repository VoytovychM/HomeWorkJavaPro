package homeworkalgorithms20240418;

public class MyStack {

    private Value top;
    public MyStack() {
        this.top = null;
    }
    public void push(int value){
        Value e = new Value(value);
        e.setNext(this.top);
        this.top = e;

    }
    public Integer pop(){
        Integer value = null;
        if(this.top != null){
            value = this.top.getValue();
            this.top = this.top.getNext();
        }
        return value;
    }

     public boolean isEmpty() {
         return top == null;
     }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());


    }

}

