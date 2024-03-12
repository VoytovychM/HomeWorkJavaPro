package homework20240306;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Strings {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("The", "truth", "will", "set", "you", "free");

        List<Integer> result1 = calculateChars(strings);
        System.out.println(result1);
        List<String> newList = getThreeCharsStrings(strings);
        System.out.println(newList);
        Integer mavValue = getLargestString(strings);
        System.out.println(mavValue);


    }

    public static List<Integer> calculateChars(List<String> inputStrings) {
        List<Integer> result = new ArrayList<>(inputStrings.size());

        for (String inputString : inputStrings) {
            int length = inputString.length();
            result.add(length);
        }

        return result;

    }

    public static List<String> getThreeCharsStrings(List<String> strings) {
        List<String> threeCharString = new ArrayList<>(strings.size());

        for (String str : strings) {
            if (str.length() > 3) {
                threeCharString.add(str);
            }

        }
        return threeCharString;
    }

    public static Integer getLargestString(List<String> strings) {
        int max = strings.get(0).length();
        for (String str : strings) {
            if (str.length() > max) {
                max = str.length();
            }
        }
        return max;
    }
}
