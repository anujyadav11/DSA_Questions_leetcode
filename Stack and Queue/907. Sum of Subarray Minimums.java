/*********************************************** JAVA **************************************************/

// Optimal Solution - Computes sum of subarray minimums using monotonic stacks to find nearest smaller boundaries and the contribution technique to count each element's impact.
/*  "The contribution technique is key — instead of finding minimums of all O(n²) subarrays, calculate how many subarrays each element is the minimum of. 
    The asymmetric strict/non-strict boundary condition between NSL and NSR prevents duplicate elements from being double-counted — always use >= on one side and > on the other." */

public class Solution {
    public int[] getNSL(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            // pop elements greater than or equal to current — find strictly smaller to left
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            // no smaller element to left — use -1 as sentinel
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }
    public int[] getNSR(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            // pop elements greater than or equal to current — find strictly smaller to right
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            // no smaller element to right — use n as sentinel
            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return result;
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        // NSL[i] = index of nearest smaller element to the left
        int[] NSL = getNSL(arr, n);
        // NSR[i] = index of nearest smaller element to the right
        int[] NSR = getNSR(arr, n);
        long sum = 0;
        int M = 1000000007;
        for (int i = 0; i < n; i++) {
            // subarrays starting between NSL[i]+1 and i
            long d1 = i - NSL[i];
            // subarrays ending between i and NSR[i]-1
            long d2 = NSR[i] - i;
            // total subarrays where arr[i] is the minimum
            long totalWaysForIMin = d1 * d2;
            // contribution of arr[i] as minimum across all those subarrays
            long sumIInTotalWays = (long) arr[i] * totalWaysForIMin;
            sum = (sum + sumIInTotalWays) % M;
        }
        return (int) sum;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(n).
