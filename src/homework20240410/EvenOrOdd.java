package homework20240410;

import java.util.List;
import java.util.function.Consumer;

public class EvenOrOdd {
// Создать Consumer, который принимает числа и печатает четные числа в поток System.out, а нечетные числа в System.err.
    private static List<Integer> numbers = List.of(1,4,7,9,6,8);

    public static void main(String[] args) {

        Consumer<Integer> identifier = (input)-> {
        if(input%2 == 0){
            System.out.println(input);
        } else{
            System.err.println(input);
        }
        };

        numbers.forEach(identifier);

    }
}

