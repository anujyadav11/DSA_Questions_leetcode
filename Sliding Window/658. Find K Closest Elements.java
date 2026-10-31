/*********************************************** JAVA **************************************************/

// Optimal Solution - Solved Find K Closest Elements using binary search on the starting index of a fixed-size window, achieving O(log(n-k+1) + k) time.
/* "Since the input is sorted, the k closest elements must form a contiguous window. Instead of checking every possible window, I binary-search its starting index. 
    At each step, I compare the distances of the elements immediately outside the candidate window. This lets me eliminate half of the possible starting positions." */

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        // Search for the starting index of the best window of size k.
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // Compare the elements just outside the candidate window.
            int leftDiff = x - arr[mid];
            int rightDiff = arr[mid + k] - x;
            if (leftDiff > rightDiff) {
                // Right side is closer, so move the window right.
                left = mid + 1;
            } else {
                // Left side is closer or equally close.
                // Prefer the smaller element in case of a tie.
                right = mid;
            }
        }
        // Collect the k elements from the optimal window.
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}

// Time Complexity :- O(log(n - k + 1) + k).
// Space Complexity :- O(1).
