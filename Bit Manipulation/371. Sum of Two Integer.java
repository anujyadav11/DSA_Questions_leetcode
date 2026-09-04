/*********************************************** JAVA **************************************************/

// Optimal Solution - Bitwise addition that computes sum without using + or - operators. XOR handles addition without carry, AND finds carry bits—iterate until carry becomes zero.
/* “I simulate binary addition using bit operations. XOR calculates the sum without considering carry, while AND identifies the carry bits. 
    I shift the carry one position to the left and repeat until there is no carry left. The remaining value in a is the final sum.” */

class Solution {
    public int getSum(int a, int b) {
        // Continue until there is no carry left
        while (b != 0) {
            // tmp stores the carry bits shifted left
            int tmp = (a & b) << 1;
            // XOR gives sum without considering carry
            a = a ^ b;
            // Update b with carry to be added in next iteration
            b = tmp;
        }
        // Final sum stored in a
        return a;
    }
}

// Time Complexity :- O(1).
// Space Complexity :- O(1).
