package blind75Sheet.islandMatrixTraversal;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix obj = new SpiralMatrix();

        int[][] input1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] input2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println("result1 = " + obj.spiralOrder(input1)); // [1,2,3,6,9,8,7,4,5]
        System.out.println("result2 = " + obj.spiralOrder(input2)); // [1,2,3,4,8,12,11,10,9,5,6,7]
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int rowBegin = 0, colBegin = 0;
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;

        List<Integer> result = new ArrayList<>();

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse right
            for (int j = colBegin; j <= colEnd; j++) {
                result.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse down
            for (int j = rowBegin; j <= rowEnd; j++) {
                result.add(matrix[j][colEnd]);
            }
            colEnd--;

            // Traverse left
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    result.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            // Traverse up
            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j--) {
                    result.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }
        return result;
    }
}

/**
 * TC= O(n^2)
 * SC= O(1)
 */