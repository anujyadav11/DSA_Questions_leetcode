/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts minimum character changes to make all consecutive pairs identical by checking each pair for mismatches in a single O(n) pass.
/* "Each pair is independent — mismatched pairs always cost exactly 1 change regardless of what characters they contain. So the answer is simply the count of mismatched pairs. 
    The even-length guarantee means i + 1 is always valid — worth mentioning to the interviewer that you've verified the bounds." */

class Solution {
    public int minChanges(String s) {
        int n = s.length();
        int changes = 0;
        // process pairs of characters — each pair must be identical
        for (int i = 0; i < n; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1))
                // one change needed to make this pair identical
                changes++;
        }
        return changes;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).
