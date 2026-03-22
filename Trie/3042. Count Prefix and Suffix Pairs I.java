/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts pairs (i,j) where words[i] is both a prefix and suffix of words[j] using brute-force string matching with an early length guard.
/* "Brute force is O(n²·L) which is acceptable for small inputs. For follow-up optimization, Z-function or KMP can check prefix-suffix conditions in O(L) preprocessing per word — 
    mention this to show awareness of scalable alternatives." */

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        // get total number of words
        int n = words.length;
        // initialize pair counter
        int count = 0;
        // fix words[i] as the potential prefix+suffix pattern
        for (int i = 0; i < n - 1; i++) {
            // check all words[j] where j > i
            for (int j = i + 1; j < n; j++) {
                String str1 = words[i];
                String str2 = words[j];
                // str1 can't be prefix/suffix of shorter str2
                if (str1.length() > str2.length())
                    continue;
                // check if str1 is both a prefix and suffix of str2
                if (str2.startsWith(str1) && str2.endsWith(str1))
                    ++count;
            }
        }
        // return total valid pairs found
        return count;
    }
}

// Time Complexity :- O(n² × L).
// Space Complexity :- O(1).
