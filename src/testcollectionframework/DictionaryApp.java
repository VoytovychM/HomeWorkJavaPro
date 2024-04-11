package testcollectionframework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryApp {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        read(dictionary);


}

public static void read(Dictionary dictionary) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a word in English: " );
    String word =  scanner.nextLine().toLowerCase();

    String result = dictionary.translate(word);
    if(result != null) {
        System.out.println(result);
    } else {
        System.out.println("Please enter the word translation for " + word + " into German " );
        String translatedWord = scanner.nextLine();
        dictionary.addTranslation(word, translatedWord);
    }

    read(dictionary);
}

static class Dictionary{
    private Map<String, String> dataBase = new HashMap<>();

    public Dictionary() {
       dataBase.put("pig", "Schwein");
       dataBase.put("love", "Liebe");
       dataBase.put("money", "Geld");
       dataBase.put("apple", "Apfel");
       dataBase.put("to send", "senden");


    }

    public String translate(String word){
        return dataBase.get(word.toLowerCase());
    }
    public void addTranslation (String englishWord, String germanWord){
        dataBase.put(englishWord.toLowerCase(), germanWord);

        }
    }
}
