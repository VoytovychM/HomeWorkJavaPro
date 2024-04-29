package testcollectionframework;

import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String text = "The Economist is a British British weekly newspaper published in printed magazine format and digitally. It focuses on current affairs, international business, politics, technology, and culture";

        // Преобразование текста в массив слов
        String[] words = text.split("\\W +");


        Map<String, Integer> wordFrequency = new TreeMap<>();

        // Подсчет частоты каждого слова
        for (String word : words) {
            word = word.toLowerCase();
            int count = wordFrequency.getOrDefault(word, 0);
                wordFrequency.put(word, count + 1);

            }
            System.out.println(wordFrequency);


    List<Map.Entry<String, Integer>> sortedWordFrequency = new ArrayList(wordFrequency.entrySet());
    Collections.sort(sortedWordFrequency, new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o2.getValue().compareTo(o1.getValue());
        }
    });
     for(Map.Entry<String, Integer> o: sortedWordFrequency){
         System.out.println(o.getKey() + " " + o.getValue());

     }

}

 }

