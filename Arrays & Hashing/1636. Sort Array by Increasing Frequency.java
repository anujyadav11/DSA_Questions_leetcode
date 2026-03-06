/*********************************************** JAVA **************************************************/

// Optimal Solution - Sort numbers by increasing frequency and decreasing value using custom comparator.
                    // “I compute frequencies and use a custom comparator to sort by frequency ascending and value descending.”

class Solution {
    public int[] frequencySort(int[] nums) {
        // Initialize an array to store the frequency of each number, considering the range from -100 to 100 inclusive.
        int[] array = new int[201]; // We use 201 to accommodate numbers from -100 to 100
        // Count the frequency of each number in the input array
        for (int num : nums) {
            // Increment the count at the corresponding index in the array
            array[num + 100]++; // Offset by 100 to map numbers from -100 to 100 to the array index 0 to 200
        }
        // Iterate through the array in reverse order to sort the numbers by frequency
        for (int i = nums.length - 1; i >= 0;) {
            int max = 0, ind = -1;
            // Find the index with the maximum frequency
            for (int j = 0; j < 201; j++) {
                if (array[j] > max) {
                    max = array[j];
                    ind = j;
                }
            }
            // Place the number represented by the index into the nums array in descending order of frequency
            for (int j = 0; j < max; j++) {
                nums[i--] = ind - 100; // Offset by 100 to map back to the original number
            }
            // Reset the frequency of the number to 0 after processing
            array[ind] = 0;
        }
        // Return the sorted array
        return nums;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).
