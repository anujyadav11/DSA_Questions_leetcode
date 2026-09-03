/*********************************************** JAVA **************************************************/

// Optimal Solution - XOR-based solution that finds the missing number by cancelling out all existing values. Since a ^ a = 0, XORing the full range with the array isolates the missing value automatically.
/* “I XOR all numbers from 0 to n and then XOR all elements in the array. Since every present number appears twice, XOR cancels those numbers out because x ^ x = 0. The only value remaining is the missing number.” */

class Solution {
    public int missingNumber(int[] nums) {
        int allXor = 0;
        // XOR all numbers from 0 to n
        for (int i = 0; i <= nums.length; i++) {
            allXor = allXor ^ i;
        }
        // XOR all numbers present in the array
        for (int num : nums) {
            allXor = allXor ^ num;
        }
        return allXor;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).
