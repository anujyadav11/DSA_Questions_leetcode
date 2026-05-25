/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts primes less than n using Sieve of Eratosthenes, marking composites from i² onward for each prime up to √n.
/*  "Starting the inner loop at i*i is the key optimization — all multiples of i smaller than i*i have already been marked by smaller primes. 
    The outer limit √n is sufficient because any composite number ≤ n must have a prime factor ≤ √n. This gives O(n log log n) vs O(n√n) for trial division." */

class Solution {
    public int countPrimes(int n) {
        // edge case: no primes less than 2
        if (n <= 2)
            return 0;
        // composite[i] = true means i is not prime
        boolean[] composite = new boolean[n];
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (!composite[i]) {
                // mark all multiples of i starting from i*i as composite
                for (int j = i * i; j < n; j += i)
                    composite[j] = true;
            }
        }
        int count = 0;
        // count all non-composite numbers in range [2, n)
        for (int i = 2; i < n; i++)
            if (!composite[i])
                count++;
        return count;
    }
}

// Time Complexity :- O(n log log n).
// Space Complexity :- O(n).
