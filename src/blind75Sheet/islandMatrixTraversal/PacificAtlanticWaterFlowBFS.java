package blind75Sheet.islandMatrixTraversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlowBFS {
    /**
     * Direction vectors: down, up, right, left.
     */
    private static final int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        PacificAtlanticWaterFlowBFS obj = new PacificAtlanticWaterFlowBFS();

        int[][] input1 = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<List<Integer>> result = obj.pacificAtlantic(input1);
        for (List<Integer> r : result) {
            System.out.println(r);
        }
    }

    /**
     * Finds all coordinates in the matrix where water can flow to both the Pacific and Atlantic oceans.
     *
     * @param matrix 2D grid of heights.
     * @return List of coordinates that can reach both oceans.
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int n = matrix.length, m = matrix[0].length;

        // Visited arrays for both oceans
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        // Queues for BFS from ocean borders
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();

        // Initialize border cells adjacent to each ocean
        for (int i = 0; i < n; i++) { //Vertical border
            pQueue.offer(new int[]{i, 0});               // Pacific - Left column
            aQueue.offer(new int[]{i, m - 1});           // Atlantic - Right column
            pacific[i][0] = true;
            atlantic[i][m - 1] = true;
        }
        for (int i = 0; i < m; i++) { //Horizontal border
            pQueue.offer(new int[]{0, i});               // Pacific - Top row
            aQueue.offer(new int[]{n - 1, i});           // Atlantic - Bottom row
            pacific[0][i] = true;
            atlantic[n - 1][i] = true;
        }

        // BFS from each ocean's border
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);

        // Find cells reachable by both oceans
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    /**
     * Performs BFS from ocean border cells and marks reachable cells.
     *
     * @param matrix  2D height grid.
     * @param queue   BFS queue initialized with border cells.
     * @param visited Boolean array to track visited cells.
     */
    public void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
        int n = matrix.length, m = matrix[0].length;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];

                // Skip out-of-bounds, already visited, or decreasing height cells
                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]) {
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }

    /**
     * Time Complexity	O(m × n)
     * Space Complexity	O(m × n)
     *
     * After submitting in leetcode, this solution performs better than 37.27% of solutions.
     */
}
