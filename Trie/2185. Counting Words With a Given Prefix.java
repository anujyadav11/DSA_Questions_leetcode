/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts words in an array that start with a given prefix using a single linear scan with Java's built-in startsWith().
/*  "This is a straightforward O(n·L) scan. For follow-up at scale — millions of words or repeated prefix queries — a Trie reduces each query to O(L) with O(total characters) build cost,
      making it far more efficient for multiple lookups." */

class Solution {
    public int prefixCount(String[] words, String pref) {
        // total number of words
        int n = words.length;
        // tracks how many words start with pref
        int count = 0;
        for (int i = 0; i < n; i++) {
            // current word being checked
            String str1 = words[i];
            // increment if current word starts with given prefix
            if (str1.startsWith(pref))
                count++;
        }
        // return total matching words
        return count;
    }
}

// Time Complexity :- O(n * l). n words each checked with startsWith in O(L) where L is length of pref.
// Space Complexity :- O(1).
