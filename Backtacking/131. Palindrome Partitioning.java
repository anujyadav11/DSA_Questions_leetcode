/*********************************************** JAVA **************************************************/

// Optimal Solution -Generate all palindrome partitions using backtracking by choosing every palindromic substring from the current index.
/* “I use backtracking to partition the string from left to right. At each index, I try every possible ending position and only choose the substring if it is a palindrome. 
    After choosing it, I recursively partition the remaining suffix. Once the entire string is consumed, I store the current partition and then backtrack.” */

class Solution {
    List<List<String>> res = new ArrayList<>();
    int n;
    public List<List<String>> partition(String s) {
        // Reset result in case the same object is reused
        res.clear();
        n = s.length();
        // Start partitioning from index 0
        backtrack(s, 0, new ArrayList<>());
        return res;
    }
    public void backtrack(String s, int partIdx, List<String> subList) {
        // Entire string has been partitioned
        if (partIdx == n) {
            res.add(new ArrayList<>(subList));
            return;
        }
        // Try every possible ending position
        for (int end = partIdx; end < n; end++) {
            // Only choose the substring if it is a palindrome
            if (isPalindrome(s, partIdx, end)) {
                // Choose current palindrome substring
                subList.add(s.substring(partIdx, end + 1));
                // Continue partitioning from the next index
                backtrack(s, end + 1, subList);
                // Backtrack
                subList.remove(subList.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String word, int start, int end) {
        // Check characters from both ends
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

// Time Complexity :- O(n^2 · 2ⁿ).
// Space Complexity :- O(n · 2ⁿ).
