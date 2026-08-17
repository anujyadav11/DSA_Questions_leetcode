/*********************************************** JAVA **************************************************/

// Optimal Solution - Trie implementation supporting efficient insert, search, and prefix lookup in O(L) time. Trie converts string operations from O(N × L) to O(L) by storing shared prefixes efficiently.

class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    public TrieNode() {
        // 26 children for lowercase English letters
        children = new TrieNode[26];
        isEnd = false;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        // Root represents the empty prefix
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode node = root;
        // Create/traverse nodes for each character
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        // Mark the end of the word
        node.isEnd = true;
    }
    public boolean search(String word) {
        TrieNode node = root;
        // Traverse the Trie for each character
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        // True only if a complete word ends here
        return node.isEnd;
    }
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        // Check whether the prefix path exists
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(N * L).
