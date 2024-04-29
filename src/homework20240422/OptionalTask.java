package homework20240422;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalTask {
    public static void main(String[] args) {
        //<List> list = Arrays.asList(Optional.of("A"), Optional.of("B"), Optional.empty());
        //Преобразовать в List

        List<Optional<String>> list = Arrays.asList(Optional.of("A"), Optional.of("B"), Optional.empty());
        System.out.println(list);
        List<String> result = list.stream()
                .filter(Optional::isPresent).map(Optional::get).toList();

//        List<String> result = list.stream().flatMap(Optional::stream).toList();
        System.out.println(result);
    }
}
