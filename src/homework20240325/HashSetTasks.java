package homework20240325;

import java.util.HashSet;
import java.util.Set;

public class HashSetTasks {
    public static void main(String[] args) {


        Set<Integer> set1 = new HashSet<>();
        set1.add(6);
        set1.add(8);
        set1.add(19);
        set1.add(20);

        Set<Integer> set2 = new HashSet();
        set2.add(7);
        set2.add(8);
        set2.add(20);

        //1. Создать Set, в котором бы находились все элементы из двух наборов

         Set<Integer> joinedSet = new HashSet<>(set1);
         joinedSet.addAll(set2);
         System.out.println(joinedSet);

         // 2.Создать Set, в котором бы находились только общие для двух наборов элементы

        Set<Integer> twinNumbers = new HashSet<>(set1);
        twinNumbers.retainAll(set2);
        System.out.println(twinNumbers);

         // 3. Создать Set, в котором бы находились только элементы, которые присутствуют в первом наборе и отсутствуют во втором

        Set<Integer> firstInSecondOutSet = new HashSet<>(set1);
        firstInSecondOutSet.removeAll(set2);
        System.out.println(firstInSecondOutSet);


    }
}
