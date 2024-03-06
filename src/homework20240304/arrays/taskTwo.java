package homework20240304.arrays;

import java.util.Arrays;

public class taskTwo {

    public static void main(String[] args) {

        String[] data = {"One", "Two", "Three"};
        reverse(data);
        System.out.println(Arrays.toString(data));

    }

    public static String[] reverse(String [] array) {
        String temp;
        for (int i = 0; i < array.length/2; i++) {
            temp = array[i];
            array[i] = array[array.length -1 - i];
            array[array.length -1 - i] = temp;
        }

        return array;
    }
}
