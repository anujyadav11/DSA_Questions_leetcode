/*********************************************** JAVA **************************************************/

// Optimal Solution - Answers range XOR queries in O(1) each using a precomputed prefix XOR array with the identity XOR(l,r) = cumXor[r] ^ cumXor[l-1].
/* "Prefix XOR is the XOR equivalent of prefix sum — range query in O(1) after O(n) build. The self-inverse property a ^ a = 0 makes this work: 
    cumXor[r] ^ cumXor[l-1] cancels all elements before index l. Always size the result array by queries.length not input array length — a common off-by-one mistake." */

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        // prefix XOR array — cumXor[i] = XOR of arr[0..i]
        int[] cumXor = new int[n];
        cumXor[0] = arr[0];
        for (int i = 1; i < n; i++)
            cumXor[i] = cumXor[i - 1] ^ arr[i];
        // answer each query in O(1) using prefix XOR
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            // XOR(l, r) = cumXor[r] ^ cumXor[l-1]
            ans[i] = cumXor[r] ^ (l == 0 ? 0 : cumXor[l - 1]);
        }
        return ans;
    }
}

// Time Complexity :- O(n + q).
// Space Complexity :- O(n). size of ans array.
