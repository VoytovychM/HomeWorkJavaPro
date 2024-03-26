package homework20240325;

public class MainStack {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.push(10);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(6);
        stack.push(3);
        stack.push(9);
        stack.push(16);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(11);
        System.out.println(stack.peek());



    }
}
