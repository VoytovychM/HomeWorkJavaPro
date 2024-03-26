package homework20240325;

public class CustomStack {
    private Element top;

    public CustomStack() {
        this.top = null;
    }
    public void push(int value){
        Element e = new Element(value);
        e.setNext(this.top);
        this.top = e;

    }
    public int pop(){
        int value = 0;
        if(this.top != null){
            value = this.top.getValue();
            this.top = this.top.getNext();
        }
        return value;
    }
    public int peek(){
        int value = 0;
        if(this.top != null){
            value = this.top.getValue();

        }
        return value;
    }
}
