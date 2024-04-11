package recursion;

public class FindMax {
    public static int findMax(int[] arr){
        return findMaxRecursive(arr, 0);

    }
    private static int findMaxRecursive(int[] arr, int index){
        if(index == arr.length){
            return Integer.MIN_VALUE;
        }
        int max = findMaxRecursive(arr, index + 1);
        return Math.max(arr[index], max);
    }

    public static void main(String[] args) {
        int[] exampleArray = {4, 7, 9, 2, 15, 14};
        int maxElement = findMax(exampleArray);
        System.out.println("Max element in massive: " + maxElement);
    }
}
