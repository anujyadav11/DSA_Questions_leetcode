/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds minimum replacements to make array consecutive by sliding a size-n window over sorted unique values and maximizing elements already in range.
/* "Deduplication is essential — duplicate values can never both fit in a consecutive range simultaneously. The window condition newNums[j] < newNums[i] + n checks if value fits in [newNums[i], newNums[i]+n-1]. 
    Two-pointer j never resets — i moves right so j only advances, giving amortized O(n) for the window scan." */

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = n;
        // deduplicate values
        HashSet<Integer> unique = new HashSet<>();
        for (int num : nums)
            unique.add(num);
        // sorted unique values array
        int[] newNums = new int[unique.size()];
        int index = 0;
        for (int num : unique)
            newNums[index++] = num;
        Arrays.sort(newNums);
        // sliding window — find max elements fitting in window [newNums[i], newNums[i]+n)
        int j = 0;
        for (int i = 0; i < newNums.length; i++) {
            // expand window right while within range
            while (j < newNums.length && newNums[j] < newNums[i] + n)
                j++;
            // count of distinct values fitting in window of size n
            int count = j - i;
            // minimum replacements = n - max elements already in window
            ans = Math.min(ans, n - count);
        }
        return ans;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(n).
