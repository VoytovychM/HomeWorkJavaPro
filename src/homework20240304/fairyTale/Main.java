package homework20240304.fairyTale;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Chest chest1 = new Chest(new Hare(new Duck(new Egg(new Needle(3)))));

        Chest chest2 = chest1.shallowCopy();
        Chest chest3 = chest1.deepCopy();

        System.out.println(Objects.equals(chest1.getHare(), chest2.getHare()));
        System.out.println(Objects.equals(chest1.getHare(), chest3.getHare()));
    }
}
