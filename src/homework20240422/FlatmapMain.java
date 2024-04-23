package homework20240422;

import java.util.Arrays;
import java.util.List;

public class FlatmapMain {
    public static void main(String[] args) {
        // a). Получить все возможные значения произведения чисел из обоих списков

        List<Integer>list1 = Arrays.asList(1, 2, 3, 5, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 1);

        list1.stream().flatMap(el1 -> list2.stream().map(el2 -> el1 * el2)).forEach(System.out::println);

        // b). Получить все возможные повторяющиеся пары чисел из обоих списков

        List <Integer[]>  equalPair =  list1.stream().flatMap(el1 -> list2.stream().filter(el2 -> el1.equals(el2)).map(el2 -> new Integer[]{el1, el2})).toList();
        equalPair.forEach(e-> System.out.println(Arrays.toString(e)));

       // с). Найти все пары чисел, которые делятся друг на друга [2, 4] [3, 6] [5, 1]

        System.out.println("------------");
        List<Integer[]> pairsDividedByEachOther  = list1.stream().flatMap(el1 -> list2.stream().filter(el2 -> (el1 % el2 == 0) || (el2 % el1 == 0))
                .map(el2-> new Integer[]{el1, el2})).toList();
       pairsDividedByEachOther.forEach(e-> System.out.println(Arrays.toString(e)));
    }
}
