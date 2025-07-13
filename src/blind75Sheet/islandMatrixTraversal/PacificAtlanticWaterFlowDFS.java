package blind75Sheet.islandMatrixTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides a solution to the Pacific Atlantic Water Flow problem on Leetcode (Q417).
 * It finds all coordinates in the matrix where water can flow to both the Pacific and Atlantic oceans.
 */
public class PacificAtlanticWaterFlowDFS {
    // Directions for DFS traversal: right, left, down, up
    private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        PacificAtlanticWaterFlowDFS obj = new PacificAtlanticWaterFlowDFS();
        int[][] input1 = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<List<Integer>> result = obj.pacificAtlantic(input1); //[0, 4],[1, 3],[1, 4],[2, 2],[3, 0],[3, 1],[4, 0]
        for (List<Integer> r : result) {
            System.out.println(r);
        }
    }

    /**
     * Main method to find cells from which water can flow to both Pacific and Atlantic oceans.
     *
     * @param matrix The height matrix of the land.
     * @return A list of coordinates where water can flow to both oceans.
     */
    private List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        // Track cells reachable from Pacific and Atlantic oceans
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        // Start DFS from all Pacific-border cells
        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);       // Left edge (Pacific)
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m - 1);   // Right edge (Atlantic)
        }

        // Start DFS from all Atlantic-border cells
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);        // Top edge (Pacific)
            dfs(matrix, atlantic, Integer.MIN_VALUE, n - 1, i);   // Bottom edge (Atlantic)
        }

        // Collect cells that can flow to both oceans
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    /**
     * DFS helper method to mark reachable cells from a given ocean.
     *
     * @param matrix  The height matrix.
     * @param visited The visited matrix for either Pacific or Atlantic.
     * @param height  The height of the previous cell.
     * @param x       Current cell row index.
     * @param y       Current cell column index.
     */
    private void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        int n = matrix.length, m = matrix[0].length;

        // Out of bounds or already visited or current cell is lower than previous height
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height) {
            return;
        }

        visited[x][y] = true;

        // Traverse in all 4 directions
        for (int[] d : dir) {
            dfs(matrix, visited, matrix[x][y], x + d[0], y + d[1]);
        }
    }

    /**
     * Time Complexity	O(m × n)
     * Space Complexity	O(m × n)
     *
     * After submitting in leetcode, this solution performs better than 97.78% of solutions.
     */

}
