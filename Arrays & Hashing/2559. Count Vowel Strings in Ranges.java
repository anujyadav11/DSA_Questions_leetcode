/*********************************************** JAVA **************************************************/

// Optimal Solution - Answers range queries on vowel-boundary words in O(1) each using a precomputed prefix sum array.
/* "Whenever multiple range queries are asked on a static array, prefix sum is the go-to pattern — O(n) build cost amortised over all queries gives O(n+q) total vs O(n·q) brute force. 
      The only edge case to handle is when l=0, where there's no cumSum[l-1] to subtract." */

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        // total words and total queries
        int n = words.length;
        int q = queries.length;
        // result array for each query answer
        int[] res = new int[q];
        // prefix sum array to answer range queries in O(1)
        int[] cumSum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // increment if word starts and ends with a vowel
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1)))
                sum++;
            // store running prefix sum at index i
            cumSum[i] = sum;
        }
        for (int i = 0; i < q; i++) {
            // extract range boundaries for current query
            int l = queries[i][0];
            int r = queries[i][1];
            // range sum = cumSum[r] - cumSum[l-1], handle l=0 edge case
            res[i] = cumSum[r] - (l > 0 ? cumSum[l - 1] : 0);
        }
        // return all query answers
        return res;
    }

    public boolean isVowel(char ch) {
        // check if character is one of the five vowels
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}

// Time Complexity :- O(n + q) — O(n) to build prefix sum, O(1) per query × q queries
// Space Complexity :- O(n).
