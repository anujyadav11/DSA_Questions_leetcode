/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds the longest substring convertible within maxCost using a sliding window that tracks cumulative character conversion costs.
/*  "Classic variable-size sliding window — expand right freely, shrink left when constraint is violated. The cost function |s[j] - t[j]| maps character conversion to a numeric budget problem. 
    The inner while loop guarantees the window is always valid when we record maxLen, making this safely O(n) since i never moves backwards." */

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int i = 0, j = 0;
        int currCost = 0;
        int maxLen = 0;
        while (j < n) {
            // add cost of converting s[j] to t[j]
            currCost += Math.abs(s.charAt(j) - t.charAt(j));
            // shrink window from left until cost is within budget
            while (currCost > maxCost) {
                currCost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            // window [i, j] is valid — update max length
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        // return longest valid substring length within maxCost
        return maxLen;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).
