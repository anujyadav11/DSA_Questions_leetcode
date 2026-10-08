/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds all majority elements appearing more than n/3 times using extended Boyer-Moore Voting with two candidates and a verification pass.
/* "The key insight is that at most 2 elements can exceed n/3 frequency. Boyer-Moore cancels triplets of distinct values — whatever survives are candidates. 
    Always do a second pass to verify since the algorithm only guarantees candidates, not confirmed majorities." */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        // Two possible candidates and their current vote counts.
        int cnt1 = 0, cnt2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        // Phase 1: Find the two possible majority candidates.
        for (int i = 0; i < n; i++) {
            // If candidate 1 has no votes and current number
            // is not already candidate 2, choose it as candidate 1.
            if (cnt1 == 0 && el2 != nums[i]) {
                cnt1 = 1;
                el1 = nums[i];
            // If candidate 2 has no votes and current number
            // is not already candidate 1, choose it as candidate 2.
            } else if (cnt2 == 0 && el1 != nums[i]) {
                cnt2 = 1;
                el2 = nums[i];
            // Current number supports candidate 1.
            } else if (el1 == nums[i]) {
                cnt1++;
            // Current number supports candidate 2.
            } else if (el2 == nums[i]) {
                cnt2++;
            // Current number matches neither candidate,
            // so it cancels one vote from both candidates.
            } else {
                cnt1--;
                cnt2--;
            }
        }
        // Phase 2: Verify the actual frequencies of the candidates.
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1)
                cnt1++;
            if (nums[i] == el2)
                cnt2++;
        }
        // A majority element must appear more than n / 3 times.
        int min = (n / 3) + 1;
        if (cnt1 >= min)
            res.add(el1);
        if (cnt2 >= min)
            res.add(el2);
        return res;
    }
}

// Time Complexity :- O(n) — two passes.
// Space Complexity :- O(1) auxiliary space, excluding the result list.
