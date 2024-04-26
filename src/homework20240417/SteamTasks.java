package homework20240417;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SteamTasks {

    static class Human implements Comparable<Human>{
       public String name;

        public Human(String name) {
            this.name = name;
        }


        @Override
        public int compareTo(Human o) {
            return this.name.compareTo(o.name);
        }
    }
    public static void main(String[] args) {
        List<Human> humanList = List.of(new Human("Tom"), new Human("Jack"), new Human("Vova"), new Human ("Masha"), new Human ("Tom"), new Human("Alex"));
        List<String> words = List.of("Banana", "Mango", "Mango", "Table", "Map", "Tree", "Tee", "Fight", "Mango");
        taskOneA(words);
        taskOneB(humanList);
        taskOneC(humanList);
        taskOneD();
        taskOneE();
        taskOneF();

        taskTwoA(words);
        System.out.println(taskTwoB(words));
        System.out.println(method(words));

    }

    public static List<String> method(List<String> strings) { // 0(n ^2) квадратичная сложность
        List result = new ArrayList<>();
        for (String s : strings) {
            if (!result.contains(s)) {
                result.add(s);
            }
        }
        return result;
    }
    private static List<String> taskTwoB(List<String> words) { // O(n)
        List<String> distinct = words.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        return distinct;
    }

    // for (String s : strings) {
    //System.out.println(s);
    //}
    private static void taskTwoA(List<String> words) {
        words.stream().forEach(System.out::println);

    }

    //Посчитать количество неповторяющихся слов в списке
    public static void taskOneA(List<String> words) {
        Integer uniqueWordsCount = words.stream().distinct().toList().size();
        System.out.println(uniqueWordsCount);

    }
    //Посчитать количество людей с именем "Tom" в списке имен
    public static void taskOneB(List<Human> humanList) {
        Long countOfNamesTom = humanList.stream().filter(human -> human.name.equals("Tom")).count();
        System.out.println(countOfNamesTom);

    }
    //- Из списка имен вывести первое по алфавиту, предпоследнее по алфавиту
    public static void taskOneC(List<Human> humanList){
        String firstName = humanList.stream().sorted().findFirst().get().name;
        System.out.println(firstName);
        String lastName = humanList.stream().sorted(Comparator.reverseOrder()).findFirst().orElse(new Human("default")).name;
        System.out.println(lastName);
    }

    //   - Посчитать количество чисел от 1 до 1000, которые делятся на 7.
    public static void taskOneD(){
      long countOfNumberDividedBySeven = IntStream.rangeClosed(1, 1000).filter(value -> value % 7 == 0).count();
        System.out.println(countOfNumberDividedBySeven);
    }
    // Посчитать сумму квадратов чисел от 1 до 100
    public static void taskOneE(){
        long sumOfSquares = IntStream.rangeClosed(1,100).map(num -> num * num).sum();
        System.out.println(sumOfSquares);
    }
    // Проверить, все ли числа из списка четные

    public static void taskOneF(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 8);
        boolean allEven = numbers.stream().allMatch(num -> num % 2 == 0);
        System.out.println(allEven);


    }
}

