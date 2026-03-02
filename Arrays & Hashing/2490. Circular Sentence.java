/*********************************************** JAVA **************************************************/

// Optimal Solution - Verify circular sentence by checking boundary characters at word transitions and sentence ends in a single pass.
                    // “Instead of splitting words, I directly check boundary characters around spaces and also compare the first and last characters.”

class Solution {
    public boolean isCircularSentence(String sentence) {
        // Check circular condition:
        // First character must equal last character
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
            return false;
        }
        // Traverse sentence to check word boundaries
        for (int i = 1; i < sentence.length() - 1; i++) {
            // If space found, check last char of previous word
            // equals first char of next word
            if (sentence.charAt(i) == ' ') {
                if (sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                    return false;
                }
            }
        }
        return true;  // All circular conditions satisfied
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).
