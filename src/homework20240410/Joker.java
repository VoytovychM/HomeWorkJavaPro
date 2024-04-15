package homework20240410;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

// 1. Создать Supplier randomJoke, который выдает пользователю случайный анекдот из заготовленного исходного списка анекдотов.
public class Joker {

    private static List<String> jokes = new ArrayList<>();

    public static void main(String[] args) {
        jokes.add("Joke 1");
        jokes.add("Joke 3");
        jokes.add("Joke 2");
        jokes.add("Joke 4");

        Supplier<String> randomJoke = ()-> {
            Random random = new Random();
            return jokes.get(random.nextInt(jokes.size() + 1));
        };

        System.out.println(randomJoke.get());

    }
}
