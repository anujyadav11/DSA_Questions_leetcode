/********************************************** JAVA ******************************************/ 

// Brute Force Approach - Brute-force solution that expands consecutive sequences by repeatedly searching for the next number.

class Solution {
    public int longestConsecutive(int[] nums) {
        int longestLength = 0;
        // Try every element as the starting point
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            int currentLength = 1;
            // Keep checking if the next consecutive number exists
            while (contains(nums, currentNumber + 1)) {
                currentNumber++;
                currentLength++;
            }
            longestLength = Math.max(longestLength, currentLength);
        }
        return longestLength;
    }
    // Linear search to check whether a number exists in the array
    public boolean contains(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return true;
        }
        return false;
    }
}

// Time Complexity :- O(n^2).
// Space Complexity :- O(1).

// Better solution - Sort the array and count consecutive runs while skipping duplicates to find the longest sequence.

class Solution {
    public int longestConsecutive(int[] nums) {
        // Sort the array so consecutive numbers become adjacent
        Arrays.sort(nums);
        // Tracks the previous unique number processed
        int previousNumber = Integer.MIN_VALUE;
        // Length of the longest sequence found
        int longestLength = 0;
        // Length of the current sequence
        int currentLength = 0;
        for (int i = 0; i < nums.length; i++) {
            // Current number extends the consecutive sequence
            if (nums[i] - 1 == previousNumber) {
                currentLength++;
                previousNumber = nums[i];
            }
            // New unique number starts a new sequence
            else if (nums[i] != previousNumber) {
                currentLength = 1;
                previousNumber = nums[i];
            }
            // Duplicate numbers are ignored
            longestLength = Math.max(longestLength, currentLength);
        }
        return longestLength;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(1).

// Optimal Approach - we are using a set for the unique value and then finding whether one less value is present in the set or not, and then finding the longest streak we have found in the set.

  class Solution {
    public int longestConsecutive(int[] nums) {
        // Edge case: if the array is empty, no consecutive sequence exists
        if (nums.length == 0) return 0;
        // HashSet to store all elements for O(1) lookup
        Set<Integer> set = new HashSet<>();
        // Insert all numbers into the set
        for (int num : nums) {
            set.add(num);
        }
        // Variable to store the length of the longest consecutive sequence
        int longest = 0;
        // Iterate through each unique number in the set
        for (int num : set) {
            // We only start counting if num is the start of a sequence
            // i.e., num - 1 does NOT exist in the set
            if (!set.contains(num - 1)) {
                int currNum = num; // current number in the sequence
                int streak = 1;    // length of current consecutive sequence
                // Count consecutive numbers forward
                while (set.contains(currNum + 1)) {
                    currNum++;
                    streak++;
                }
                // Update the longest sequence found so far
                longest = Math.max(longest, streak);
            }
        }
        return longest;
    }
}

// Time Complexity :- O(n);
// Space Complexity :- O(n);
