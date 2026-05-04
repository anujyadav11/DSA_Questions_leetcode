/*********************************************** JAVA **************************************************/

// Optimal Solution - Builds lexicographically largest repeat-limited string by greedily appending the largest character up to the limit, inserting the next largest as separator when needed.
/* "The separator trick is key — when a character exceeds its repeat limit, one occurrence of the next largest character resets the streak while keeping the string as large as possible. 
    Not decrementing index after appending the separator is critical — we return to the same character next iteration to continue exhausting it." */

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        // count frequency of each character
        int[] count = new int[26];
        for (char ch : s.toCharArray())
            count[ch - 'a']++;
        StringBuilder sb = new StringBuilder();
        // start from the largest character
        int index = 25;
        while (index >= 0) {
            // skip exhausted characters
            if (count[index] == 0) {
                index--;
                continue;
            }
            // append at most repeatLimit occurrences of current character
            int used = Math.min(count[index], repeatLimit);
            for (int k = 0; k < used; k++)
                sb.append((char) ('a' + index));
            count[index] -= used;
            // if current character still has remaining count — insert next largest as separator
            if (count[index] > 0) {
                int prevIndex = index - 1;
                // find next available smaller character
                while (prevIndex >= 0 && count[prevIndex] == 0)
                    prevIndex--;
                // no smaller character available — stop
                if (prevIndex < 0) break;
                // insert one occurrence of next largest as separator
                sb.append((char) ('a' + prevIndex));
                count[prevIndex]--;
            }
        }
        return sb.toString();
    }
}

// Time Complexity :- O(n + 26).
// Space Complexity :- O(n).
