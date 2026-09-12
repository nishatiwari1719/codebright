package blind75Sheet.backtracking;

/**
 * LC 211. Design Add and Search Words Data Structure
 */
class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();

        // Add words
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");

        // Debug search calls
        System.out.println(obj.search("pad")); // false
        System.out.println(obj.search("bad")); // true
        System.out.println(obj.search(".ad")); // true
        System.out.println(obj.search("b..")); // true
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            TrieNode curr = node.children[c - 'a']; // we check if c is present in node's children
            if (curr == null) { // means character c is not present in its children
                node.children[c - 'a'] = new TrieNode(); // so we will create a new TrieNode and assign this character as one of its children
                curr = node.children[c - 'a']; // also assign it to current curr
            }
            node = curr;
        }
        node.isLast = true;
    }

    public boolean search(String word) {
        return find(0, word, root);
    }

    // Recursive function
    private boolean find(int index, String word, TrieNode node) {
        // what happens when dot is at the end
        if (index == word.length() - 1) {
            if (word.charAt(index) == '.') {
                for (int i = 0; i < 26; i++) {
                    if (node.children[i] != null && node.children[i].isLast) {
                        return true;
                    }
                }
                return false;
            }
            // what if the last character is not null and not dot (base case)
            if (node.children[word.charAt(index) - 'a'] != null
                    && node.children[word.charAt(index) - 'a'].isLast) {
                return true;
            }
            return false;
        }
        // Dot in the middle
        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && find(index + 1, word, node.children[i])) {
                    return true;
                }
            }
            return false;
        }

        // No dot, some character
        if (node.children[word.charAt(index) - 'a'] != null) {
            return find(index + 1, word, node.children[word.charAt(index) - 'a']);
        }
        return false;
    }

    class TrieNode {
        TrieNode[] children;
        boolean isLast;

        public TrieNode() {
            children = new TrieNode[26];
            isLast = false;
        }
    }
}

/**
 * Final
 * | Operation           | Time Complexity | Space Complexity |
 * | ------------------- | --------------- | ---------------- |
 * | `addWord`           | `O(L)`          | `O(1)` extra     |
 * | `search` (no `.`)   | `O(L)`          | `O(1)`           |
 * | `search` (with `.`) | `O(26^L)` worst | `O(L)` stack     |
 * | Trie storage        | —               | `O(N * L)`       |
 * <p>
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */