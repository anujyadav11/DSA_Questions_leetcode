/*********************************************** JAVA **************************************************/

// Optimal Solution - Find the majority element using Boyer-Moore Voting in O(n) time and O(1) space.
/* “I use Boyer-Moore Voting to find the majority element in one pass. Matching elements increase the candidate’s vote count, 
    while different elements cancel one vote. Since the majority element occurs more than n/2 times, it will survive the cancellation process.” */

class Solution {
    public int majorityElement(int[] nums) {
        // Candidate for the majority element and its current vote count.
        int majority = nums[0], votes = 1;

        for (int i = 1; i < nums.length; i++) {

            // If the current candidate has no votes,
            // choose the current element as the new candidate.
            if (votes == 0) {
                votes++;
                majority = nums[i];

            // Same element supports the current candidate.
            } else if (majority == nums[i]) {
                votes++;

            // Different element cancels one vote of the candidate.
            } else {
                votes--;
            }
        }

        // The majority element survives the cancellation process.
        return majority;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).
