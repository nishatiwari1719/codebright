package blind75Sheet.trie.implementTrieLeetcode.secondBestSolution.bruteForceSolution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    // Second best approach: Use two Sets for words and prefixes each. Compute prefixes while inserting words.
    Set<String> words;
    Set<String> prefixes;

    public Trie() {
        words = new HashSet<>();
        prefixes = new HashSet<>();
    }

    public void insert(String word) {
        words.add(word);
        for (int i = 1; i <= word.length(); i++) {
            prefixes.add(word.substring(0, i));
        }
    }

    public boolean search(String word) {
        return words.contains(word);
    }

    public boolean startsWith(String prefix) {
        return prefixes.contains(prefix);
    }
}
