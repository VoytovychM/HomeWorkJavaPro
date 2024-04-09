package recursion;

public class FindIndex {
    public static int find(int[] arr, int x){
        return binarySearch(arr, x, 0, arr.length - 1);
    }
    private static int binarySearch(int[] arr, int x, int left, int right){
        if(left > right){
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] == x){
            return mid;
        } else if (arr[mid] < x){
                return binarySearch(arr, x, mid + 1, right);

            } else {
            return binarySearch(arr,x,left, mid - 1);
        }
    }

    public static void main(String[] args) {
      int[] exampleArray = {11, 22, 44, 50, 60, 86, 114, 140, 145, 190};
      int index = find(exampleArray, 114);
        System.out.println(index);
    }
}
