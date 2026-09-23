/*********************************************** JAVA **************************************************/

// Optimal Solution - BFS-based shortest path solution for Word Ladder using character-level transformations. This is a shortest path problem in an unweighted graph — BFS guarantees minimum transformations.
/* “I model the words as an implicit unweighted graph, where two words are connected if they differ by one character. Since we need the shortest transformation sequence, I use BFS. 
    For every word, I change each character to every letter from a to z and check whether the resulting word exists in the dictionary. I use a HashSet for constant-time dictionary lookup and another set to avoid visiting the same word multiple times. 
    Because BFS explores level by level, the first time I reach the end word gives the shortest transformation length.” */

class Solution {
    public int ladderLength(String beginWord,String endWord,List<String> wordList) {
        // Convert the word list to a HashSet for O(1) lookup
        Set<String> words = new HashSet<>(wordList);
        // If the target word doesn't exist, no transformation is possible
        if (!words.contains(endWord)) {
            return 0;
        }
        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);
        que.offer(null);
        Set<String> vis = new HashSet<>();
        vis.add(beginWord);
        int level = 1;
        while (!que.isEmpty()) {
            String word = que.poll();
            // End of current BFS level
            if (word == null) {
                level++;
                if (!que.isEmpty()) {
                    que.offer(null);
                }
                continue;
            }
            // Reached the target
            if (word.equals(endWord)) {
                return level;
            }
            // Try changing every character
            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    // Avoid generating the same word
                    if (chars[i] == c) {
                        continue;
                    }
                    chars[i] = c;
                    String nextWord = new String(chars);
                    // Only visit valid and unvisited words
                    if (words.contains(nextWord) && !vis.contains(nextWord)) {
                        vis.add(nextWord);
                        que.offer(nextWord);
                    }
                }
            }
        }
        return 0;
    }
}

// Time Complexity :- O(n * W * 26).
//Space Complexity :- O(n).
