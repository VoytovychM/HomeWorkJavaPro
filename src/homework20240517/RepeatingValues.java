package homework20240517;

import java.util.*;
import java.util.stream.Collectors;

public class RepeatingValues {

    public static int[] removeRepeatingValues(int[] array){
        if(array== null){
            return new int[0];
        }
        LinkedHashSet<Integer> set = Arrays.stream(array).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
        return set.stream().mapToInt(value -> value).toArray();
    }

}
