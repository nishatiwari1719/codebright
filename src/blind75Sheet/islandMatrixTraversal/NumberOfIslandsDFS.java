package blind75Sheet.islandMatrixTraversal;

public class NumberOfIslandsDFS {
    public static void main(String[] args) {
        NumberOfIslandsDFS obj = new NumberOfIslandsDFS();

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
        System.out.println("input1 = " + obj.numIslands(input1)); //1
        System.out.println("input2 = " + obj.numIslands(input2)); //3
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0'; // Mark the cell as visited

        // Explore all four directions
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    /**
     * TC = O(m x n), SC = O(m x n)
     *
     * Space Complexity:
     * DFS uses recursive calls, so the maximum depth of recursion depends on the shape of the island.
     * In the worst case, if the island covers the entire grid (e.g., a big rectangle of '1's), the recursion can go
     * as deep as m × n levels (in pathological, snake-like cases).
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
