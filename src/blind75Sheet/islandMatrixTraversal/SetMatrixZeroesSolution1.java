package blind75Sheet.islandMatrixTraversal;

import java.util.Arrays;

public class SetMatrixZeroesSolution1 {
    public static void main(String[] args) {
        SetMatrixZeroesSolution1 obj = new SetMatrixZeroesSolution1();

        int[][] input1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] input2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        System.out.println("result1 = " + Arrays.deepToString(obj.setZeroes(input1))); // [[1,0,1],[0,0,0],[1,0,1]]
        System.out.println("result2 = " + Arrays.deepToString(obj.setZeroes(input2))); // [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
    }

    public int[][] setZeroes(int[][] matrix) {
        boolean firstRow = false, firstCol = false;

        // Set markers in first row and first col
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRow = true;
                    }
                    if (j == 0) {
                        firstCol = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Replace values in inner matrix
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Replace values in first row
        if (firstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        // Replace values in first col
        if (firstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }
}

/**
 * TC= O(m x n)
 * SC= O(1)
 *
 * In Leetcode, this one is slower as compared to solution 2. But ideally this one should be faster.
 */