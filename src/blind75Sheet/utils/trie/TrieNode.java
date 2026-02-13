package blind75Sheet.utils.trie;

public class TrieNode {
    public boolean isWord;
    public TrieNode[] children;

    public TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
}
