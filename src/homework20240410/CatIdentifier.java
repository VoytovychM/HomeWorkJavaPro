package homework20240410;

import java.util.List;
import java.util.function.Predicate;

//Создать Predicate isWhiteCat, который проверяет, белого ли цвета кошка Cat.
public class CatIdentifier {
    static class Cat {
        String color;

        public Cat(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "color='" + color + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Cat> cats = List.of(new Cat ("White"), new Cat("Black"), new Cat ("Ginger"));
        Predicate<Cat> isWhiteCat = (cat) -> {
            return cat.getColor().equals("White");
        };

        for(Cat cat: cats){
            System.out.println(cat);
            System.out.println("Is cat white? " + isWhiteCat.test(cat));
        }
    }
}
