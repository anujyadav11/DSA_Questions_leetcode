/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds max-min marble distribution difference by sorting adjacent pair sums and greedily selecting k-1 largest/smallest split points.
/* "The key insight is that first and last elements always appear in the score regardless of splits — so only the k-1 split boundaries matter. 
    Each boundary contributes the sum of its two adjacent elements. Sorting and picking extremes is the greedy — k-1 largest splits maximize, k-1 smallest minimize. 
    The answer is their difference." */

class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int m = n - 1;
        // pairSum[i] = cost of splitting between index i and i+1
        int[] pairSum = new int[m];
        for (int i = 0; i < m; i++)
            pairSum[i] = weights[i] + weights[i + 1];
        // sort to easily access k-1 smallest and largest split costs
        Arrays.sort(pairSum);
        long maxSum = 0;
        long minSum = 0;
        // pick k-1 largest splits for max, k-1 smallest for min
        for (int i = 0; i < k - 1; i++) {
            minSum += pairSum[i];
            maxSum += pairSum[m - 1 - i];
        }
        // difference between max and min distributions
        return maxSum - minSum;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(n).
