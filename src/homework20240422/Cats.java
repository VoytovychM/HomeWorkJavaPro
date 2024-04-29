package homework20240422;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cats {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Tom", "black", 2);
        Cat cat2 = new Cat("Mikky", "white", 1);
        Cat cat3 = new Cat("Vasya", "white", 3);
        Cat cat4 = new Cat("Steve", "grey", 1);
        Cat cat5 = new Cat("Bob", "black", 5);
        List<Cat> catList = Arrays.asList(cat1, cat2, cat3, cat4, cat5);

        // Получить Map имя / цвет

        Map<String, String> colorCatMap = catList.stream().collect(Collectors.toMap(Cat::getName, Cat::getColor));
        System.out.println(colorCatMap);

        // Получить Map цвет / количество кошек данного цвета
        Map<String, Long> catColorCount = catList.stream().collect(Collectors.groupingBy(Cat::getColor, Collectors.counting()));
        System.out.println(catColorCount);

        // Получить Map> цвет / список имен кошек данного цвета
        Map<String, List<String>> namesOfCatsBycolor = catList.stream().collect(Collectors.groupingBy(Cat::getColor, Collectors.mapping(c->c.getName(), Collectors.toList())));
        System.out.println(namesOfCatsBycolor);

        // Получить Map возраст / количество белых кошек данного возраста

        Map<Integer, Integer> countOfWhiteByAge = catList.stream().collect(Collectors.toMap(Cat::getAge, cat -> cat.getColor().equals("white") ? 1 : 0, Integer::sum));
        System.out.println(countOfWhiteByAge);


    }
}
