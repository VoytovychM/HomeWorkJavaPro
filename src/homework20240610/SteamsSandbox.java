package homework20240610;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
// Составить массив с большим объемом тестовых данных. С помощью стримов отсортировать данные
//последовательно
//параллельно
//Замерить и сравнить затраченное время.

public class SteamsSandbox {
    public static void main(String[] args) throws InterruptedException {
        long start;
        long end;


        int arrayLength = 100_000_000;
        Random random = new Random();
        int[] array = IntStream.range(1, arrayLength).map(i -> random.nextInt()).toArray();
        int[] array1 = array.clone();
        int[] array2 = array.clone();
        start = System.currentTimeMillis();

        Arrays.stream(array1).sorted().toArray();
        end = System.currentTimeMillis();

        System.out.println("Time elapsed sequentially: " + (end - start));

        start = System.currentTimeMillis();
        Arrays.stream(array2).parallel().sorted().toArray();
        end = System.currentTimeMillis();

        System.out.println("Time elapsed parallel: " + (end - start));


    }

}
