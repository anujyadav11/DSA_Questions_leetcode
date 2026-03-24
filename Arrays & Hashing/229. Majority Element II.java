/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds all majority elements appearing more than n/3 times using extended Boyer-Moore Voting with two candidates and a verification pass.
/* "The key insight is that at most 2 elements can exceed n/3 frequency. Boyer-Moore cancels triplets of distinct values — whatever survives are candidates. 
    Always do a second pass to verify since the algorithm only guarantees candidates, not confirmed majorities." */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        // two candidates and their counts for Boyer-Moore Voting
        int cnt1 = 0, cnt2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // assign nums[i] as first candidate if slot is empty and not equal to el2
            if (cnt1 == 0 && el2 != nums[i]) {
                cnt1 = 1;
                el1 = nums[i];
            // assign nums[i] as second candidate if slot is empty and not equal to el1
            } else if (cnt2 == 0 && el1 != nums[i]) {
                cnt2 = 1;
                el2 = nums[i];
            // current element matches first candidate
            } else if (nums[i] == el1) {
                cnt1++;
            // current element matches second candidate
            } else if (nums[i] == el2) {
                cnt2++;
            // current element matches neither — cancel one of each
            } else {
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> res = new ArrayList<>();
        // reset counts for verification pass
        cnt1 = 0;
        cnt2 = 0;
        // verify actual frequencies of both candidates
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) cnt1++;
            if (nums[i] == el2) cnt2++;
        }
        // threshold: must appear more than n/3 times
        int mini = (n / 3) + 1;
        // add candidates that truly exceed the threshold
        if (cnt1 >= mini) res.add(el1);
        if (cnt2 >= mini) res.add(el2);
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).
