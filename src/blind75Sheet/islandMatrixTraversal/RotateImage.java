package blind75Sheet.islandMatrixTraversal;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        RotateImage obj = new RotateImage();

        int[][] input1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] input2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        System.out.println("result1 = " + Arrays.deepToString(obj.rotate(input1))); // [[7,4,1],[8,5,2],[9,6,3]]
        System.out.println("result2 = " + Arrays.deepToString(obj.rotate(input2))); // [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    }

    public int[][] rotate(int[][] matrix) {
        int n = matrix[0].length;

        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        return matrix;
    }
}

/**
 * TC= O(m x n)
 * SC= O(1)
 */