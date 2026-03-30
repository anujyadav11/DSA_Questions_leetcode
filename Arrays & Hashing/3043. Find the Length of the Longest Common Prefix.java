/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds the longest common numeric prefix between two arrays by hashing all prefixes of arr1 and trimming arr2 numbers until a match is found.
/* "The key insight is treating number prefixes as integers — dividing by 10 strips the last digit, giving all prefixes without string conversion. 
    Storing arr1 prefixes in a HashSet reduces each arr2 lookup to O(d) where d ≤ 10, making the overall solution effectively O(n+m)." */

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> st = new HashSet<>();
        // insert all numeric prefixes of every number in arr1
        for (int val : arr1) {
            // repeatedly trim last digit until all prefixes are stored
            while (!st.contains(val) && val > 0) {
                st.add(val);
                // remove last digit to get next shorter prefix
                val /= 10;
            }
        }
        int result = 0;
        for (int num : arr2) {
            // trim arr2 number until a matching prefix from arr1 is found
            while (!st.contains(num) && num > 0)
                num /= 10;
            if (num > 0)
                // number of digits in matched prefix = length of common prefix
                result = Math.max(result, (int) (Math.log10(num) + 1));
        }
        // return length of longest common numeric prefix
        return result;
    }
}

// Time Complexity :- O(n * d + m * d).
// Space Complexity :- O(n * d).
