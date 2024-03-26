package homework20240325;

public class Element {
   private int value;
   private Element next;

   public Element(int value){
       this.next = null;
       this.value = value;
   }

    public int getValue() {
        return value;
    }

    public Element getNext() {
        return this.next;
    }

    public void setNext(Element next) {
        this.next = next;
    }
}
