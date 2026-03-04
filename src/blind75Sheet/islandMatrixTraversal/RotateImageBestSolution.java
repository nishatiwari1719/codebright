package blind75Sheet.islandMatrixTraversal;

import java.util.Arrays;

/**
 * Optimal as well as easy to read.
 * Transpose + Reverse = two-step clean method.
 */
public class RotateImageBestSolution {
    public static void main(String[] args) {
        RotateImageBestSolution obj = new RotateImageBestSolution();

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

        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }

        return matrix;
    }
}

/**
 * TC= O(n^2)
 * SC= O(1)
 */