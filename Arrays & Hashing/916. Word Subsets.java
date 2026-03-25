/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds universal words in words1 that are supersets of all words2 by merging words2 into a single max-frequency requirement array.
/* "The key insight is collapsing all words2 into one merged frequency array using element-wise max — this turns an O(n×m) problem into O(n+m). 
    A word in words1 is universal if and only if it satisfies this single merged requirement." */

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // merged frequency: max count needed for each letter across all words2
        int[] freq = new int[26];
        for (String word : words2) {
            int[] temp = getFreq(word);
            // take max per character to satisfy all words2 simultaneously
            for (int i = 0; i < 26; i++)
                freq[i] = Math.max(freq[i], temp[i]);
        }
        List<String> res = new ArrayList<>();
        for (String word : words1) {
            int[] temp = getFreq(word);
            boolean flag = true;
            // check if word covers every character requirement in merged freq
            for (int i = 0; i < 26; i++) {
                if (freq[i] > temp[i]) {
                    // word is missing at least one required character count
                    flag = false;
                    break;
                }
            }
            // word satisfies all words2 requirements — add to result
            if (flag) res.add(word);
        }
        return res;
    }
    public int[] getFreq(String word) {
        int[] count = new int[26];
        // count frequency of each character in the word
        for (int i = 0; i < word.length(); i++)
            count[word.charAt(i) - 'a']++;
        return count;
    }
}

// Time Complexity :- O(n * l + m * l). l is average word length.
// Space Complexity :- O(1). because we are using constant 26 size array.
