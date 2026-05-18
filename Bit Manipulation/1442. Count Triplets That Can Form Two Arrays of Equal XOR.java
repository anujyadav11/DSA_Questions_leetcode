/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts valid triplets by finding equal prefix XOR pairs — each such pair at distance d contributes d-1 valid middle positions.
/* "When prefix[i] == prefix[k], XOR of the subarray arr[i..k-1] is 0 — meaning it can be split at any point into two equal XOR halves. 
    So instead of iterating over all j, we count k - i - 1 valid splits at once. This reduces O(n³) brute force to O(n²) — mention O(n) HashMap approach as follow-up for bonus points." */

class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        // prefix[i] = XOR of arr[0..i-1]
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        for (int i = 1; i <= n; i++)
            prefix[i] = prefix[i - 1] ^ arr[i - 1];
        int triplets = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k <= n; k++) {
                // if prefix[i] == prefix[k], XOR of arr[i..k-1] is 0
                // any j in (i, k) gives valid triplet — count = k - i - 1
                if (prefix[k] == prefix[i])
                    triplets += k - i - 1;
            }
        }
        return triplets;
    }
}

// Time Complexity :- O(n^2).
// Space Complexity :- O(n).
