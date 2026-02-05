package blind75Sheet.knapsack;

public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths obj = new UniquePaths();

        // Test Case 1
        int m1 = 3, n1 = 7;
        int result1 = obj.uniquePaths(m1, n1);
        System.out.println("m=" + m1 + ", n=" + n1 + ", result=" + result1);

        // Test Case 2
        int m2 = 3, n2 = 2;
        int result2 = obj.uniquePaths(m2, n2);
        System.out.println("m=" + m2 + ", n=" + n2 + ", result=" + result2);
    }

    //    Memoization, TC=O(m x n), SC=O(m x n)
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
                }
            }
        }

        return grid[m - 1][n - 1];
    }
}
