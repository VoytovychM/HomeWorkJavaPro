package homework20240304.arrays;

import static homework20240304.arrays.taskThree.printMatrix;

public class taskFour {
    public static void main(String[] args) {
//        int[][] ints2DArray = new int[3][3];
//        ints2DArray[0][0] = 1;
//        ints2DArray[1][1] = 1;
//        ints2DArray[2][2] = 1;
//        int[][] ints2DArray3 = generateMatrix(3,3);
//        printMatrix(ints2DArray3);

        int[][] ints2DArray5 = generateMatrix(3,5);
        printMatrix(ints2DArray5);


    }

    public static int[][] generateMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < Math.min(rows, cols); i++) {
                matrix[i][i] = 1;
        }

        return matrix;
    }


}

