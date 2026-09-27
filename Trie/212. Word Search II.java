/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds all dictionary words in a character grid using Trie-guided DFS and backtracking with prefix pruning and duplicate elimination.f
/* “I build a Trie containing all target words, then run DFS from every board cell. During DFS, I follow the corresponding Trie path. If the current character doesn’t exist in the Trie, 
    I immediately stop that branch, which provides strong pruning. When a Trie node contains a complete word, I add it to the result and set the stored word to null to avoid duplicates. 
    I mark board cells as visited during recursion and restore them during backtracking.” */

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        // Build a Trie containing all words.
        TrieNode root = buildTrie(words);
        // Start DFS from every cell in the board.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
    public void dfs(char[][] board, int i, int j,TrieNode p, List<String> res) {
        char c = board[i][j];
        // Stop if:
        // 1. The cell is already used in the current path.
        // 2. There is no Trie path for this character.
        if (c == '#' || p.next[c - 'a'] == null)
            return;
        // Move to the Trie node representing the current character.
        p = p.next[c - 'a'];
        // If this Trie node represents a complete word,
        // we found a valid word.
        if (p.word != null) {
            res.add(p.word);
            // Mark it as null so that the same word
            // is not added multiple times.
            p.word = null;
        }
        // Mark the current board cell as visited.
        board[i][j] = '#';
        // Explore all four directions.
        if (i > 0) dfs(board, i - 1, j, p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        // Restore the original character for backtracking.
        board[i][j] = c;
    }
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        // Insert every word into the Trie.
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                // Create a Trie node if this character
                // does not already exist.
                if (p.next[i] == null)
                    p.next[i] = new TrieNode();
                p = p.next[i];
            }
            // Store the complete word at the terminal node.
            p.word = w;
        }
        return root;
    }
    // Each Trie node contains:
    // - next: children for 26 lowercase letters
    // - word: complete word ending at this node
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}

// Time Complexity :- O(WL + MN × 4^L) worst-case bound.
// Space Complexity :- O(WL + L).
