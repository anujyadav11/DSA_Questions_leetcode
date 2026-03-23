/*********************************************** JAVA **************************************************/

// Optimal Solution - Custom sorts a string by prioritizing characters in a given order using frequency counting, appending remaining characters naturally at the end.
/* "This is counting sort with a custom priority. Count all chars in s, drain counts in order's sequence first, 
    then drain leftovers. The key insight is that the second loop safely skips already-zeroed counts — no explicit visited set needed." */

class Solution {
    public String customSortString(String order, String s) {
        // frequency array for all 26 lowercase letters in s
        int count[] = new int[26];
        // count occurrences of each character in s
        for (char c : s.toCharArray())
            ++count[c - 'a'];
        StringBuilder sb = new StringBuilder();
        // append characters that exist in order, in order's sequence
        for (char c : order.toCharArray()) {
            // append c exactly count[c] times, then zeroes out count
            while (count[c - 'a']-- > 0)
                sb.append(c);
        }
        // append remaining characters not present in order
        for (char c = 'a'; c <= 'z'; c++) {
            // append leftover c's that weren't in order
            while (count[c - 'a']-- > 0)
                sb.append(c);
        }
        // return the custom sorted string
        return sb.toString();
    }
}

// Time Complexity :- O(n + m). — O(n) to count chars in s, O(m) to build ordered part, O(26) for leftover loop = O(n + m).
// Space Complexity :- O(n). StringBuilder holds all n characters of s.
