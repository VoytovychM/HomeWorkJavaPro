package homework20240424;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Написать метод, который принимает список любого типа и возвращает его в виде нового списка с элементами в обратном порядке.
public class ReserveOrder {

    public static  List<?> reverseOrder (List<?> input){ // public static <T> List <T> reverseList (List<T> list) { - этот вариант лучше тк как мы точно знаем какой параметр будет
        List<?> reverseList = new ArrayList<>(input); // public static void reeverseList (List<?> list) не возвращает новый список
        Collections.reverse(reverseList); // есть списки неизменяемые и тогда будет выбрасывать exception
        return reverseList;
    }
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("Love");
        stringList.add("Respect");
        stringList.add("Honesty");
        stringList.add("Justice");

        System.out.println(stringList);
        System.out.println(reverseOrder(stringList));

        List<Integer> integerList = new ArrayList<>();
        integerList.add(123);
        integerList.add(456);
        integerList.add(789);
        integerList.add(1011);
        System.out.println(integerList);
        System.out.println(reverseOrder(integerList));

    }
}
