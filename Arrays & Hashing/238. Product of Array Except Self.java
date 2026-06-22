/********************************************** JAVA ***********************************************/

// Optimal Approach - using two pointers and a res array for calculating the product of the array except itself

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // Result array where res[i] will store the product of all elements except nums[i]
        int[] res = new int[n];
        // left will store the product of all elements to the left of index i
        int left = 1;
        // First pass: compute left products
        // res[i] = product of elements before index i
        for (int i = 0; i < n; i++) {
            res[i] = left;
            left *= nums[i]; // update left product
        }
        // right will store the product of all elements to the right of index i
        int right = 1;
        // Second pass: compute right products and multiply with left products
        // res[i] = left product * right product
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i]; // update right product
        }
        return res;
    }
}

// Time Complexity :- O(N)
// Space Complexity:- O(1)

// Simpler Approach with extra space 
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // left[i] = product of all elements before index i
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        // right[i] = product of all elements after index i
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        // Result array
        int[] result = new int[n];
        // Product except self = left product × right product
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}

// Time Complexity :- O(N)
// Space Complexity:- O(N)
