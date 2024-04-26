package mergevsquicksort;

public class DualPivotExample {
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int low, int high) {
        if (low < high) {
            int[] pivots = partition(array, low, high);
            sort(array, low, pivots[0] - 1);
            sort(array, pivots[0] + 1, pivots[1] - 1);
            sort(array, pivots[1] + 1, high);
        }
    }

    private static int[] partition(int[] array, int low, int high) {
        if (array[low] > array[high]) {
            swap(array, low, high);
        }

        int pivot1 = array[low];
        int pivot2 = array[high];

        int left = low + 1;
        int right = high - 1;
        int i = left;

        while (i <= right) {
            if (array[i] < pivot1) {
                swap(array, i, left);
                left++;
            } else if (array[i] >= pivot2) {
                while (array[right] > pivot2 && i < right) {
                    right--;
                }
                swap(array, i, right);
                right--;
                if (array[i] < pivot1) {
                    swap(array, i, left);
                    left++;
                }
            }
            i++;
        }
        left--;
        right++;

        swap(array, low, left);
        swap(array, high, right);

        return new int[]{left, right};
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6, 3};
        System.out.println("Array before sorting:");
        printArray(array);

        sort(array);

        System.out.println("\nArray after Dual Pivot QuickSort:");
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

