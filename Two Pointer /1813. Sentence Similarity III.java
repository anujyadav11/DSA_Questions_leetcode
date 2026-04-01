/*********************************************** JAVA **************************************************/

// Optimal Solution - Checks sentence similarity by greedily matching common prefix and suffix words, verifying the shorter sentence is fully consumed by both passes.

/* "The key insight is that insertion only happens in the middle — so prefix and suffix must match exactly. Two pointers consume matching words from both ends of the shorter sentence. 
    If start > end1 after both passes, every word in the shorter sentence was accounted for, confirming valid similarity." */

class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // ensure sentence1 is always the shorter one for consistent logic
        if (sentence1.length() > sentence2.length())
            return areSentencesSimilar(sentence2, sentence1);
        String[] smallerWord = sentence1.split(" ");
        String[] largerWord = sentence2.split(" ");
        int start = 0;
        int end1 = smallerWord.length - 1;
        int end2 = largerWord.length - 1;
        // match words from the left (common prefix)
        while (start <= end1 && smallerWord[start].equals(largerWord[start]))
            start++;
        // match words from the right (common suffix)
        while (start <= end1 && smallerWord[end1].equals(largerWord[end2])) {
            end1--;
            end2--;
        }
        // if all words of smaller sentence matched — valid similar sentences
        return start > end1;
    }
}

// Time Complexity :- O(n + m) — splitting both sentences plus two linear pointer passes, where n, m are word counts.
// Space Complexity :- O(n + m) — two word arrays from split().
