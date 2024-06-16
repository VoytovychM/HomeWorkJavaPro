package homework20240515;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTasks {

    //  Напишите метод поиска в тексте всех слов, начинающихся с определенной буквы.
    public static List<String> findWordsStartingWithL(String text, char letter) {
        List<String> words = new ArrayList<>();
        String regex = "\\b" + Pattern.quote(String.valueOf(letter)) + "\\w*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {  //return matcher.results().map(MatchResult::group).toList();
            words.add(matcher.group());
        }

        return words;
    }
    public static void main(String[] args) {
        // 1. Напишите регулярное выражение, которое соответствует любому номеру телефона согласно формату:
        //телефонный номер состоит из 7 цифр подряд или из 3х цифр, пробела или тире, а затем из 4 цифр (1234567, 123-4567, 123 4567).

        String regex = "\\d{7}|\\d{3}[-\\s]\\d{4}"; //[\\d]{3} [-\\s]?[\\d]{4}
        System.out.println(Pattern.matches(regex, "1234567"));
        System.out.println(Pattern.matches(regex, "123-4567"));
        System.out.println(Pattern.matches(regex, "123 4567"));
        System.out.println(Pattern.matches(regex, "123==4567"));


        // 2. Имеется текст "Php is the best programming language in the world. I study php." Замените в нем php на java.
        String text = "Php is the best programming language in the world. I study php. Love it.";
        String regex2 = "(?i)php";
        String updatedText = text.replaceFirst(regex2, "Java").replaceAll(regex2,"java");
        System.out.println(updatedText);

        //3. Имеется некоторый текст. Найти и вывести из него все группы гласных, стоящие вместе. Например: a, ua, uiy

        String regex3 = "[aeiouAEIOU]+";
        Pattern pattern = Pattern.compile(regex3);
        Matcher matcher = pattern.matcher(updatedText);
        while (matcher.find()){
            System.out.println(matcher.group());
        }

        char letter = 'l';
        List<String> words = findWordsStartingWithL(text, letter);
        System.out.println(words);

    }


        }


