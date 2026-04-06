/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts substrings containing all three characters using a sliding window, batch-counting valid extensions with n−right when all three are present.
/* "The key insight is count += (n - right) — once the window is valid, fixing the left boundary gives n - right valid substrings by extending right to any end position. 
    Shrinking left while valid collects all minimal valid windows efficiently, making it O(n) instead of O(n²) brute force." */

class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        // frequency array for 'a', 'b', 'c' only
        int[] freq = new int[3];
        int count = 0;
        // tracks how many distinct chars among a,b,c are present in window
        int currCount = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            freq[ch - 'a']++;
            // new distinct character entered the window
            if (freq[ch - 'a'] == 1)
                currCount++;
            // window contains all 3 — every extension to the right is also valid
            while (currCount == 3) {
                // all substrings from current window to end of string are valid
                count += (n - right);
                // shrink window from left
                char c = s.charAt(left);
                freq[c - 'a']--;
                // lost a distinct character from window
                if (freq[c - 'a'] == 0)
                    currCount--;
                left++;
            }
        }
        // return total substrings containing at least one a, b, and c
        return count;
    }
}

// Time Complexity :- O(2n).
// Space Complexity :- O(1).
