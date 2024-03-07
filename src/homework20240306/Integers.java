package homework20240306;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Integers {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>(3);
        integerList.add(59);
        integerList.add(27);
        integerList.add(66);
        integerList.add(100);
        int q = 2;

        Integer sum = calculateSum(integerList);
        System.out.println(sum);

        Integer max = getLargestInteger(integerList);
        System.out.println(max);


        boolean sort = isSorted(integerList);
        System.out.println("Before sorting: " + sort);
        Collections.sort(integerList);
        sort = isSorted(integerList);
        System.out.println("After sorting: " + sort);
        List<Integer> result = getSeparatedList(integerList,q);
        System.out.println(integerList);
        System.out.println("Values divided on " + q + ": " + result);

    }

    public static Integer calculateSum(List<Integer> integerList) {
        int sum = 0;
        for (Integer i : integerList) {
            sum += i;
        }
        return sum;
    }

    public static Integer getLargestInteger(List<Integer> integerList) {
        int max = 0;
        for (Integer i : integerList) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static boolean isSorted(List<Integer> integerList) {
        if (integerList == null || integerList.isEmpty())
            return true;
        for (int i = 0; i < integerList.size() - 1; i++) {
            if (integerList.get(i) > integerList.get(i+1)) {
                return false;
            }

        }
        return true;

    }

    public static List<Integer> getSeparatedList (List<Integer> integerList, int q){
        List<Integer> result = new ArrayList<>();
        for(Integer i: integerList){
            if(i % q == 0){
                result.add(i);
            }
        }
        return result;
    }
}