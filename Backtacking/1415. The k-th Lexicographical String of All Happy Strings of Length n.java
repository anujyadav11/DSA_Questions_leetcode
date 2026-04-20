/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds the k-th lexicographic happy string of length n using backtracking with adjacent-duplicate skipping and early exit on k-th completion.
/* "The bug is a classic backtracking mistake — capturing len before append then using it to delete after. Always use cur.length() - 1 after appending since the length changed. 
    Early return true propagation is the optimization — once the k-th string is found, unwind immediately without exploring remaining branches." */

class Solution {
    String res;
    int count;
    public String getHappyString(int n, int k) {
        res = "";
        count = 0;
        backtrack(n, k, new StringBuilder());
        return res;
    }
    public boolean backtrack(int n, int k, StringBuilder cur) {
        // base case: built a complete happy string of length n
        if (cur.length() == n) {
            count++;
            // found the k-th happy string
            if (count == k) {
                res = cur.toString();
                return true;
            }
            return false;
        }
        for (char ch = 'a'; ch <= 'c'; ch++) {
            // skip if same as last character — happy string rule
            if (cur.length() > 0 && cur.charAt(cur.length() - 1) == ch)
                continue;
            cur.append(ch);
            // early exit if k-th string found in this branch
            if (backtrack(n, k, cur)) return true;
            // delete last char using current length not pre-append length
            cur.deleteCharAt(cur.length() - 1);
        }
        return false;
    }
}

// Time Complexity :- O(2^n). - at each position 2 choices (can't repeat last char); early exit often reduces this significantly
// Space Complexity :- O(n). size of StringBuilder.
