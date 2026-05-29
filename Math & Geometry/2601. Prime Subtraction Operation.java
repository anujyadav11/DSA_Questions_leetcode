/*********************************************** JAVA **************************************************/

// Optimal Solution - Use a greedy right-to-left traversal and prime subtraction (precomputed with sieve) to make the array strictly increasing.
/* “I process the array from right to left because the next element is already fixed. Whenever an element is not smaller than its neighbor, 
    I subtract a prime to make it just small enough while keeping it as large as possible.” */

class Solution {
    boolean[] isPrime = new boolean[1000];
    // Sieve of Eratosthenes to precompute prime numbers up to 999
    void sieve() {
        // Assume all numbers are prime initially
        Arrays.fill(isPrime, true);
        // 0 and 1 are not prime
        isPrime[0] = false;
        isPrime[1] = false;
        // Mark multiples of each prime as non-prime
        for (int i = 2; i * i < 1000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 1000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        // Precompute all primes
        sieve();
        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            // Already strictly smaller than next element
            if (nums[i] < nums[i + 1]) {
                continue;
            }
            // Try subtracting a prime number
            for (int prime = 2; prime < nums[i]; prime++) {
                if (!isPrime[prime]) {
                    continue;
                }
                /*
                Find a prime such that:
                nums[i] - prime < nums[i + 1]
                */
                if (nums[i] - prime < nums[i + 1]) {
                    nums[i] -= prime;
                    break;
                }
            }
            // If still not strictly smaller, impossible
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

// Time Complexity :- O(n * maxNum).
// Space Complexity :- O(1). ~ O(1000).
