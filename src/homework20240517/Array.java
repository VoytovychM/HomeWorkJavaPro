package homework20240517;

import java.util.HashSet;
import java.util.Set;

public class Array {

    public static Set<Integer> findCommonElements(int[] array1, int[] array2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : array1) {
            set1.add(num);
        }

        for (int num : array2) {
            set2.add(num);
        }

        set1.retainAll(set2);

        return set1;
    }
}
