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
        int[] array = IntStream.range(1, arrayLength).map(i -> random.nextInt(1000)).toArray();
//        int[] array1 = array.clone();/ not needed
//        int[] array2 = array.clone(); / not needed
        start = System.currentTimeMillis();

        Arrays.stream(array).sorted().toArray();
        end = System.currentTimeMillis();

        System.out.println("Time elapsed sequentially: " + (end - start));

        start = System.currentTimeMillis();
        Arrays.stream(array).parallel().sorted().toArray();
        end = System.currentTimeMillis();

        System.out.println("Time elapsed parallel: " + (end - start));


    }

}
