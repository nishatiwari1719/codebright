package blind75Sheet.backtracking;

import java.util.*;

public class WordSearch2Solution2 {
    public static void main(String[] args) {
        WordSearch2Solution2 obj = new WordSearch2Solution2();

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

    // 66.2 aka new code
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = buildTrie(words);
        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie, res, i, j);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(char[][] board, Trie node, Set<String> res, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                board[i][j] == '#' || node.next[board[i][j] - 'a'] == null) {
            return;
        }

        if (node.next[board[i][j] - 'a'].word != null) {
            res.add(node.next[board[i][j] - 'a'].word);
        }

        node = node.next[board[i][j] - 'a'];
        char c = board[i][j];
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
