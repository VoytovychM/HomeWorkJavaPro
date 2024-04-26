package homework20240415;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

//Написать метод reduce(), который на вход принимает список чисел, оператор двух аргументов и начальное значение. Метод накапливает результат применения
// оператора по всем данных, начиная с начального значения.
//public static Integer reduce(List list, BinaryOperator operator, Integer basicValue)
//Например, вызов reduce(list, Integer::sum, 0)) должен вернуть сумму всех чисел
//reduce(list, (i, j) -> i * j, 1) должен вернуть произведение всех чисел
public class ReduceMethod {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10,20,30,40,50);

        System.out.println(reduce(list, (i,j)-> i * j, 5));
        System.out.println(reduce(list, Integer::sum, 0));
    }


    public static Integer reduce(List<Integer> list, BinaryOperator<Integer> operator, Integer basicValue) {
//        Integer result = list.stream().reduce(basicValue,operator);
        Integer result = basicValue;
        for (Integer elem:list){
            result= operator.apply(result,elem);
        }
        return result;
    }
}
