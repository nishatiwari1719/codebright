package blind75Sheet.trie.implementTrieLeetcode.bruteForceSolution;

import java.util.ArrayList;
import java.util.List;

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
    // Brute Force Approach
    List<String> words;

    public Trie() {
        words = new ArrayList<>();
    }

    public void insert(String word) {
        words.add(word);
    }

    public boolean search(String word) {
        for (String w : words) {
            if (w.equals(word))
                return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        for (String w : words) {
            if (w.startsWith(prefix))
                return true;
        }
        return false;
    }
}
