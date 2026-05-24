/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds closest prime pair in [left,right] using Sieve of Eratosthenes followed by linear scan tracking consecutive prime gaps.
/* "Sieve of Eratosthenes is O(R log log R) — nearly linear. The key detail is starting inner loop at p*p not 2*p — all smaller multiples already marked by earlier primes.
    For very large ranges where memory is tight, a segmented sieve processes [left, right] directly using O(√R) space instead of O(R)." */

class Solution {
    public int[] closestPrimes(int left, int right) {
        // sieve of eratosthenes — mark all primes up to right
        boolean[] prime = new boolean[right + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        if (right >= 1) prime[1] = false;
        for (int p = 2; p * p <= right; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= right; i += p)
                    prime[i] = false;
            }
        }
        int[] res = new int[]{-1, -1};
        int minDiff = Integer.MAX_VALUE;
        int prev = -1;
        // scan range [left, right] for closest prime pair
        for (int i = left; i <= right; i++) {
            if (prime[i]) {
                if (prev == -1) {
                    // first prime found — initialize prev
                    prev = i;
                } else {
                    // found second prime — check if closer than current best
                    if (i - prev < minDiff) {
                        minDiff = i - prev;
                        res[0] = prev;
                        res[1] = i;
                    }
                    // advance prev to current prime for next comparison
                    prev = i;
                }
            }
        }
        return res;
    }
}

// Time Complexity :- O(R log log R + (R - L)).
// Space Complexity :- O(R).
