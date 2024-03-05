package homework20240304.fairyTale;

public class Main {
    public static void main(String[] args) {
        Chest c1 = new Chest(new Hare(new Duck(new Egg(new Needle(3)))));
        Chest c2 =  new Chest(new Hare(new Duck(new Egg(new Needle(5)))));

        if (c1.equals(c2)) {
            System.out.println("c1 equals c2");
        } else {
            System.out.println("c1 not equals c2");
        }

        Chest clonec1 = c1.deepCopy();

        if (clonec1.equals(c1)) {
            System.out.println("clonec1 equals c2");
        } else {
            System.out.println("clonec1 not equals c2");
        }

    }
}
