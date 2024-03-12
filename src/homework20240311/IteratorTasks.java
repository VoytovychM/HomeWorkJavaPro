package homework20240311;

import java.util.*;


public class IteratorTasks {
    public static void main(String[] args) {
        List names = new ArrayList<>(Arrays.asList("Mary", "Jane", "Tom", "Tim", "Mark", "Ann", null, ""));
        //a

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String newString = iterator.next();
            if (newString != null && newString.length() == 4) {
                System.out.println(newString);
            }

        }
         //b
        iterator = names.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element == null || element.isEmpty()) {
                iterator.remove();
            }
        }
        System.out.println(names);
//        // a
        ListIterator<String> listIterator = names.listIterator();
        while(listIterator.hasNext()){
            String elementRemoved = listIterator.next();
            if(elementRemoved != null && elementRemoved.charAt(0) == 'T'){
                listIterator.remove();
            }
        }
        System.out.println(names);
//        // b
        for (int i = 0; i < names.size(); i++) {
            if("Ann".equals(names.get(i))){
                names.set(i, "student Ann");
            }

        }
        System.out.println(names);
    }
}




