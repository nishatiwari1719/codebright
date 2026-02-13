package blind75Sheet.trie;

import blind75Sheet.utils.trie.TrieNode;

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
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}
