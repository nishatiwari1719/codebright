package blind75Sheet.backtracking;

import java.util.Arrays;

public class WordSearch {
    public static void main(String[] args) {
        WordSearch obj = new WordSearch();

        // Test Case 1
        char[][] board1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word1 = "ABCCED";
        boolean result1 = obj.exist(board1, word1);
        System.out.println("board=" + Arrays.deepToString(board1) + ", word=" + word1 + ", result=" + result1);
        System.out.println();

        // Test Case 2
        char[][] board2 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word2 = "SEE";
        boolean result2 = obj.exist(board2, word2);
        System.out.println("board=" + Arrays.deepToString(board2) + ", word=" + word2 + ", result=" + result2);
        System.out.println();

        // Test Case 3
        char[][] board3 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word3 = "ABCB";
        boolean result3 = obj.exist(board3, word3);
        System.out.println("board=" + Arrays.deepToString(board3) + ", word=" + word3 + ", result=" + result3);
        System.out.println();
    }

    // TC=O(R×C×4^L), SC=O(L)
    // R is number of rows, C is number of columns in the board, and L is the length of the word being searched.
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int index, String word) {
        // Base case: full word match
        if (index == word.length()) {
            return true;
        }

        // Boundary + mismatch check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark cell as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all four directions
        boolean found = dfs(board, i + 1, j, index + 1, word) ||
                dfs(board, i - 1, j, index + 1, word) ||
                dfs(board, i, j + 1, index + 1, word) ||
                dfs(board, i, j - 1, index + 1, word);

        // Backtrack (restore original value)
        board[i][j] = temp;

        return found;
    }
}
