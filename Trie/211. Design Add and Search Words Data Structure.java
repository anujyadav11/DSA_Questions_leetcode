/*********************************************** JAVA **************************************************/

// Optimal Solution - Trie-based WordDictionary supporting wildcard '.' search using DFS backtracking. Use a Trie for prefix search, and when encountering '.', use DFS to explore all possible branches.
/* “I store every word in a Trie. For normal characters, search follows the corresponding child directly. When I encounter ., I recursively try every existing child because it can represent any character. 
    Once the entire search string is consumed, I return isEnd to ensure the path represents a complete inserted word.” */
 
class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    public TrieNode() {
        children = new TrieNode[26];
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    public void addWord(String word) {
        TrieNode node = root;
        // Insert each character into the Trie
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        // Mark complete word
        node.isEnd = true;
    }
    public boolean search(String word) {
        return searchUtil(root, word, 0);
    }
    private boolean searchUtil(TrieNode node, String word, int index) {
        // Entire word matched
        if (index == word.length()) {
            return node.isEnd;
        }
        char ch = word.charAt(index);
        // '.' can match any character
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null &&
                    searchUtil(node.children[i], word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
        // Normal character
        int childIndex = ch - 'a';
        if (node.children[childIndex] == null) {
            return false;
        }
        return searchUtil(node.children[childIndex],word,index + 1);
    }
}

// Time Complexity :- O(26^L).
// Space Complexity :- O(N * L).
