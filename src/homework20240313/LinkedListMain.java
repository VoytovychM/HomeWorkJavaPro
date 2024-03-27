package homework20240313;

import java.util.*;

public class LinkedListMain {
    public static void main(String[] args) {

         //TaskNo1
        List<String> list = new LinkedList<>();
        list.add ("Elephant");
        list.add("Cat");
        list.add ("Fish");

        System.out.println(list);

        String shortestWord = null;
        for (String animal: list){
          if( shortestWord == null || shortestWord.length() > animal.length()) {
              shortestWord = animal;
          }
        }
        System.out.println("SHORTEST WORD: " + shortestWord);


        //TaskNo2
        StringBuilder stringBuilder = new StringBuilder();
        for (String animal: list){
            stringBuilder.append(animal);
            stringBuilder.append("|");
        }
        System.out.println(stringBuilder);

        //TaskNo3
        List<TestClass> listClass = new LinkedList<>();
        listClass.add (new TestClass("Elephant"));
        listClass.add(new TestClass("Cat"));
        listClass.add (new TestClass("Fish"));

        Iterator<TestClass> iterator = listClass.iterator();
        while(iterator.hasNext()){
            TestClass current = iterator.next();
            if(current.getField().equals("Cat")) iterator.remove();
        }
        System.out.println(listClass);

        //TaskNo4

       LinkedList<Integer> integerList = new LinkedList<>();
       integerList.add(1);
       integerList.add(4);
       integerList.add(3);
       integerList.add(2);
       integerList.add(1);
       integerList.add(2);
       integerList.add(2);
       integerList.add(0);
       System.out.println(Collections.binarySearch(integerList, 2));

       int element = 2;
       int[] result = findFirstAndLastIndex(integerList, element);
        System.out.println("First index: " + result[0]);
        System.out.println("Last index: " + result[1]);

    }
       public static int[] findFirstAndLastIndex (LinkedList<Integer> integerList, int element){
        int firstIndex = -1;
        int lastIndex = -1;
           for (int i = 0; i < integerList.size(); i++) {
               if (integerList.get(i) == element){
                   if (firstIndex == -1){
                       firstIndex =i;
                   }
               lastIndex =i;
           }
       }
           return new int[]{firstIndex, lastIndex};


    }

}
