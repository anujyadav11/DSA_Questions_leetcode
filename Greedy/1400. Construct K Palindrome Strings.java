/*********************************************** JAVA **************************************************/

// Optimal Solution - Checks if k palindromes are constructible by verifying odd-frequency character count doesn't exceed k, since each palindrome absorbs at most one odd centre.
/* "The minimum number of palindromes needed equals the number of odd-frequency characters — each must be a centre in its own palindrome. So the answer is simply oddCount <= k && k <= n. 
    The n == k early return is technically covered by the main logic, but adds clarity for the interviewer." */

class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        // can't form more palindromes than characters available
        if (k > n)
            return false;
        // each character forms its own palindrome — always possible
        if (n == k)
            return true;
        // count frequency of each character
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        // count characters with odd frequency
        int oddCount = 0;
        for (int i = 0; i < 26; i++)
            if (count[i] % 2 != 0)
                oddCount++;
        // each palindrome can absorb at most one odd-frequency character
        return oddCount <= k;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(26).
