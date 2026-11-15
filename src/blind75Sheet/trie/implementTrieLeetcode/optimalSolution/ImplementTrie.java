package blind75Sheet.trie.implementTrieLeetcode.optimalSolution;

/**
 * LC 208. Implement Trie (Prefix Tree)
 */
class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println("Insert apple   ~~ ");
        trie.insert("apple");
        System.out.println("Search apple   ~~ " + trie.search("apple"));   // return True
        System.out.println("Search app     ~~ " + trie.search("app"));     // return False
        System.out.println("Startswith app ~~ " + trie.startsWith("app")); // return True
        System.out.println("Insert app     ~~ ");
        trie.insert("app");
        System.out.println("Search app     ~~ " + trie.search("app"));     // return True
    }
}

class Trie {
    // Optimal approach
    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = traverse(word);
        return node != null && node.isEnd == true;
    }

    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }

    private Trie traverse(String s) {
        Trie node = this;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
