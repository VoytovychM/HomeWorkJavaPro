package homework20240424;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

//Переделать метод reduce() в классе ReduceMethod (пакет summary20240419) так, чтобы этот метод
// мог производить операции над данными любого типа
public class ReduceMethod {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        Integer sum = reduce(list, Integer::sum, 0);
        System.out.println(sum);

        Integer multiply = reduce(list, (accumulator, element) -> accumulator * element, 1);
        System.out.println(multiply);

        Integer reduced = list.stream().reduce(0, Integer::sum);
        System.out.println(reduced);
//        reduced = list.stream().reduce(Integer::sum).get();

        sum = list.stream().mapToInt(value -> value).sum();

        // 1. a^2 + b^2 + c^2
        Integer sumSquare = list.stream().reduce(0, (acc, element) -> acc + element * element);
        System.out.println(sumSquare);

        // 2. Дан список слов "Specific" "Measurable" "Achievable" "Relevant" "Time-bound".
        // С помощью стримов вывести его аббревиатуру в виде S.M.A.R.T
        List<String> strings = Arrays.asList("Specific", "Measurable", "Achievable", "Relevant", "Time-bound");
        String string = strings.stream().reduce((s1, s2) -> s1 + s2).get();
        System.out.println(string);

        // map() ----> reduce()
        String smart = strings.stream().map(s -> s.substring(0, 1)).reduce((s1, s2) -> s1 + "." + s2).get();
        System.out.println(smart);

        // max()
        Integer max = list.stream().reduce(Math::max).get();
        System.out.println(max);

    }

    public static <T extends Number> T reduce(List<T> list, BinaryOperator<T> operator, T basicValue) {
        T result = basicValue;
        for (T element : list) {
            result = operator.apply(result, element);
        }
        return result;
    }
}
