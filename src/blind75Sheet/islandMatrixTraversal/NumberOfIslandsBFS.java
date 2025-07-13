package blind75Sheet.islandMatrixTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {
    public static void main(String[] args) {
        NumberOfIslandsBFS obj = new NumberOfIslandsBFS();

        char[][] input1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] input2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("input1 = " + obj.numIslandsBFS(input1)); //1
        System.out.println("input2 = " + obj.numIslandsBFS(input2)); //3
    }

    private int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Right, Down, Left, Up

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') { // Found an island
                    islands++;
                    bfs(grid, r, c, directions);
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, int r, int c, int[][] directions) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        grid[r][c] = '0'; // Mark as visited

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1') {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0'; // Mark as visited
                }
            }
        }
    }

    /**
     * TC = O(m x n), SC = O(min(m, n))
     *
     * Space Complexity:
     * BFS or iterative DFS, where the queue or stack grows depending on the frontier of expansion.
     * In the worst case, the queue (or stack) holds only the current layer of nodes (cells) being processed.
     *
     * | Space Complexity | Description                                                     | When it Occurs               |
     * | ---------------- | --------------------------------------------------------------- | ---------------------------- |
     * | `O(m × n)`       | Memory used per cell (explicit visited array or deep recursion) | Recursive DFS, visited\[]\[] |
     * | `O(min(m, n))`   | Only frontier (edge) cells are held at once                     | BFS or iterative DFS         |
     *
     *  Which one is better?
     *  O(min(m, n)) is much more efficient in memory usage, especially on large grids.
     *  It avoids StackOverflowError from recursion.
     *  Iterative BFS/DFS is preferred in practice when space is a concern.
     */
}
