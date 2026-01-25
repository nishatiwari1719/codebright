package blind75Sheet.islandMatrixTraversal;

import java.util.Arrays;

public class SetMatrixZeroesSolution2 {
    public static void main(String[] args) {
        SetMatrixZeroesSolution2 obj = new SetMatrixZeroesSolution2();

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
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (row[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            if (col[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }
}

/**
 * TC= O(m x n)
 * SC= O(m + n)
 */