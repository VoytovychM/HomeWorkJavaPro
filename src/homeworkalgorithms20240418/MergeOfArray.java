package homeworkalgorithms20240418;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeOfArray {
    public static void main(String[] args) {

        int[] array1 = {2,4,7,11};
//        int[] array2 = {1, 3, 4, 5, 8, 12};
        int[] array2 = {8,12};
        int[] array3 = new int[array1.length + array2.length];
        mergeTwoArrays(array1, array2, array3);
        System.out.println(Arrays.toString(array3));

        int[] arr1 = {2, 4, 7, 11};
        int[] arr2 = {8, 12};
        int[] arr3 = {4, 9, 11};
        int[] arr4 = new int[arr1.length + arr2.length + arr3.length];
        mergeThreeArrays(arr1, arr2, arr3, arr4);
        System.out.println(Arrays.toString(arr4));

    }

    public static void mergeTwoArrays (int[] array1, int[] array2, int[] array3){
        // => {1,2,3,4,4,5,7,8,11,12}
        int i = 0;
        int j = 0;
        int k = 0;
        int m = array1.length;
        int n = array2.length;
        while(i < m && j < n) {
          if (array1[i] <= array2[j]){
              array3[k] = array1[i];
              i++;
          } else{
              array3[k] = array2[j];
              j++;

          }
          k++;
        }
        if(i < m){
            for (int p = i; p < m; p++) {
                array3[k] = array1[p];
                k++;
            }
        } else{
            for (int p = j; p < n; p++) {
                array3[k] = array2[p];
                k++;
            }
        }
    }

    public static void mergeThreeArrays(int[] array1, int[] array2, int[] array3, int[] array4) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < array1.length || j < array2.length || k < array3.length) {
            if (i < array1.length && (j >= array2.length || array1[i] <= array2[j]) && (k >= array3.length || array1[i] <= array3[k])) {
                array4[i + j + k] = array1[i];
                i++;
            } else if (j < array2.length && (i >= array1.length || array2[j] <= array1[i]) && (k >= array3.length || array2[j] <= array3[k])) {
                array4[i + j + k] = array2[j];
                j++;
            } else {
                array4[i + j + k] = array3[k];
                k++;
            }
        }
    }
}