package homework20240415;

import java.util.function.Function;

// 1. Создать три функции:
//f1 - умножает Integer на 10
//f2 - преобразует Integer в String в формате "<<123>>"
//f3 - считает число символов в String
public class ThreeFunctions {
    public static void main(String[] args) {
        Function<Integer, Integer>  function1 = i -> i * 10;
        Function<Integer, String> function2 = i -> "<<" + i  + ">>";
        Function<String, Integer> function3 = s -> s.length();
        Function<Integer, Integer> compositeFunction = function1.andThen(function2).andThen(function3);

        Integer result = compositeFunction.apply(777);
        System.out.println(result);

        Function<String, String> compositeFunction2 = function3.andThen(function1).andThen(function2);
        String result2 = compositeFunction2.apply("Hello!");
        System.out.println(result2);
    }
}
