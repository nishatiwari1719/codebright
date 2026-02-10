package blind75Sheet.backtracking;

/**
 * LC 211. Design Add and Search Words Data Structure
 */
class WordDictionary {

    boolean isEndOfWord;
    private WordDictionary[] children;
    public WordDictionary() {
        children = new WordDictionary[26];
        isEndOfWord = false;
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
        WordDictionary curr = this;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new WordDictionary();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        WordDictionary curr = this;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (c == '.') {
                for (WordDictionary ch : curr.children) {
                    if (ch != null && ch.search(word.substring(i + 1))) {
                        return true;
                    }
                }
                return false;
            }
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr != null && curr.isEndOfWord;
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
 */

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */