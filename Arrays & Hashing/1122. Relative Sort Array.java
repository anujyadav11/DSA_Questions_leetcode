/*********************************************** JAVA **************************************************/

// Optimal Solution - Use counting sort to reorder elements of arr1 based on arr2 and append remaining elements in ascending order.
                      // “I use a frequency array to count occurrences, place elements following arr2’s order, and then append the remaining numbers in sorted order.”

class Solution {
    // Method to sort the elements of arr1 according to the relative order specified in arr2
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Initialize an array to count the occurrences of each element in arr1
        int[] cnt = new int[1001]; // As specified, elements are in the range of [0, 1000]
        // Count the occurrences of each element in arr1
        for (int n : arr1) {
            cnt[n]++;
        }
        // Iterate through the elements of arr2
        int i = 0;
        for (int n : arr2) {
            // For each element in arr2, append it to arr1 based on its count in cnt array
            while (cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        // Append the remaining elements in arr1 (which are not present in arr2) in ascending order
        for (int n = 0; n < cnt.length; n++) {
            while (cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        // Return the sorted arr1
        return arr1;
    }
}

// Time Complexity :- O(n + m).
// Space Complexity :- O(1).
