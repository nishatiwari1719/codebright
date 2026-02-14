package blind75Sheet.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearch2Solution1 {
    public static void main(String[] args) {
        WordSearch2Solution1 obj = new WordSearch2Solution1();

        // Test Case 1
        char[][] board1 = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words1 = {"oath", "pea", "eat", "rain"};
        System.out.println("board=" + Arrays.deepToString(board1) + ", words=" + Arrays.toString(words1) + ", Output: " + obj.findWords(board1, words1));
        System.out.println();

        // Test Case 2
        char[][] board2 = {
                {'a', 'b'},
                {'c', 'd'}
        };
        String[] words2 = {"abcb"};
        System.out.println("board=" + Arrays.deepToString(board2) + ", words=" + Arrays.toString(words2) + ", Output: " + obj.findWords(board2, words2));
    }

    // 66.1 aka old code (most optimal)
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = buildTrie(words);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie, res, i, j);
            }
        }
        return res;
    }

    public void dfs(char[][] board, Trie node, List<String> res, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                board[i][j] == '#' || node.next[board[i][j] - 'a'] == null) {
            return;
        }
        char c = board[i][j];

        node = node.next[board[i][j] - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        dfs(board, node, res, i - 1, j);
        dfs(board, node, res, i + 1, j);
        dfs(board, node, res, i, j - 1);
        dfs(board, node, res, i, j + 1);
        board[i][j] = c;
    }

    public Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (String w : words) {
            Trie p = root;
            for (char c : w.toCharArray()) {
                if (p.next[c - 'a'] == null) {
                    p.next[c - 'a'] = new Trie();
                }
                p = p.next[c - 'a']; // will point to current char
            }
            p.word = w;
        }
        return root;
    }

    private class Trie {
        Trie[] next = new Trie[26];
        String word = null;
    }
}
