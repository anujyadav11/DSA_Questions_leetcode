/*********************************************** JAVA **************************************************/

// Optimal Solution - Minimizes the maximum bag size after splits using binary search on the answer, counting required operations via ceiling division per bag.
/*  "This is identical in structure to minimizedMaximum — binary search on the answer with a greedy feasibility check. The ceiling division ceil(num/mid) gives bags needed, 
    so ceil(num/mid) - 1 is splits needed. Prefer (num + mid - 1) / mid over Math.ceil((double)num/mid) in interviews to avoid floating point edge cases." */

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        // upper bound is the largest bag — no point searching beyond it
        int r = 0;
        for (int num : nums)
            r = Math.max(r, num);
        int l = 1;
        int res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isPossible(nums, mid, maxOperations)) {
                // mid works — try smaller penalty
                res = mid;
                r = mid - 1;
            } else {
                // mid too small — need larger bag size
                l = mid + 1;
            }
        }
        // return minimized maximum bag size
        return res;
    }
    public boolean isPossible(int[] nums, int maxBalls, int maxOperations) {
        int ops = 0;
        for (int num : nums) {
            if (num > maxBalls) {
                // ceil(num / maxBalls) bags needed — requires that many minus 1 splits
                int bags = (int) Math.ceil(num / (double) maxBalls);
                ops += bags - 1;
            }
            // early exit — already exceeded allowed operations
            if (ops > maxOperations) return false;
        }
        // total splits within allowed operations
        return true;
    }
}

// Time Complexity :- O(n log Max(nums)).
// Space Complexity :- O(1).
