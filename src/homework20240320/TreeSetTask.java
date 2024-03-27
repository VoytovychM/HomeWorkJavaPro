package homework20240320;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTask {

    public static void main(String[] args) {
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(4);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(22);
        treeSet.add(5);
        treeSet.add(6);
        treeSet.add(7);
        treeSet.add(8);
        treeSet.add(9);
        treeSet.add(10);
        System.out.println(treeSet);

        int requiredNumber = 10;


        if(treeSet.contains(requiredNumber)){
            System.out.println(requiredNumber);
        }

        int maxNumber = ((TreeSet<Integer>) treeSet).last();
        System.out.println(maxNumber);

        int minNumber = ((TreeSet<Integer>) treeSet).first();
        System.out.println(minNumber);

        System.out.println("---------------");
        for (int evenNum: treeSet){
            if(evenNum % 2 == 0){
                System.out.println(evenNum);
            }
        }
        System.out.println("---------------");

       TreeSet<Integer> reversedSet = new TreeSet<>(Comparator.reverseOrder());
       reversedSet.addAll(treeSet);
       for (int num: reversedSet){
           System.out.println(num);
       }
        System.out.println("---------------");
//       reversedSet.headSet(7);
       for(int num: treeSet){
           if(num < 7){
               System.out.println(num);
           } else {
               break;
           }
       }
    }
}
