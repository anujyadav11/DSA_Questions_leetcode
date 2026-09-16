/*********************************************** JAVA **************************************************/

// Optimal Solution - Fast exponentiation using divide-and-conquer to compute power in logarithmic time. Use binary exponentiation: square the base and halve the power to reduce time complexity from linear to logarithmic.
/*“ I use binary exponentiation instead of multiplying x by itself n times. For an even exponent, I square the base and divide the exponent by two. For an odd exponent, 
    I take one factor of x and apply the same technique to the remaining even exponent. For negative exponents, I replace x with 1/x. I use long for the exponent to safely handle Integer.MIN_VALUE.” */

class Solution {
    // Calculates x^n using recursive binary exponentiation
    public double solve(double x, long n) {
        // Base case:
        // x^0 = 1 
        if (n == 0) return 1;
        // Handle negative exponent:
        // x^(-n) = (1/x)^n
        // n is long, so -n is safe even when
        // the original int was Integer.MIN_VALUE.
        if (n < 0) return solve(1 / x, -n);
        // If exponent is even:
        // x^n = (x²)^(n/2)
        // This reduces the exponent by half.
        if (n % 2 == 0) return solve(x * x, n / 2);
        // If exponent is odd:
        // x^n = x * x^(n-1)
        //    = x * (x²)^((n-1)/2)
        else return x * solve(x * x, (n - 1) / 2);
    }
    public double myPow(double x, int n) {
        // Convert n to long before passing it to solve().
        // This is important for Integer.MIN_VALUE.
        return solve(x, (long) n);
    }
}

// Time Complexity :- O(log |n|).
//Space Complexity :- O(log |n|).
