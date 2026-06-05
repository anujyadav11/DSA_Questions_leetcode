/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds maximum score word subset using backtracking with letter frequency tracking, restoring state after each include branch.

class Solution {
    int maxScore;
    int n;
    public void solve(int i, int[] score, String[] words, int curScore, int[] freq) {
        // update maxScore at every valid state
        maxScore = Math.max(maxScore, curScore);
        if (i >= n)
            return;
        // try including words[i]
        int j = 0;
        int tempScore = 0;
        boolean valid = true;
        while (j < words[i].length()) {
            char ch = words[i].charAt(j);
            freq[ch - 'a']--;
            tempScore += score[ch - 'a'];
            if (freq[ch - 'a'] < 0) {
                valid = false;
                break;
            }
            j++;
        }
        if (valid)
            solve(i + 1, score, words, curScore + tempScore, freq);
        //restore freq — backtrack all decremented chars
        for (int k = 0; k <= j && k < words[i].length(); k++)
            freq[words[i].charAt(k) - 'a']++;
        // skip words[i]
        solve(i + 1, score, words, curScore, freq);
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        for (char ch : letters)
            freq[ch - 'a']++;
        maxScore = 0;
        n = words.length;
        solve(0, score, words, 0, freq);
        return maxScore;
    }
}

// Time Complexity :- O(2^n × L).
// Space Complexity :- O(n).
