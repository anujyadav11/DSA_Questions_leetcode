/*********************************************** JAVA **************************************************/

// Optimal Solution - Solved Asteroid Collision using a stack-based simulation with O(n) amortized time complexity.
/* “I use a stack to maintain surviving asteroids. When a negative asteroid arrives, I repeatedly remove smaller positive asteroids from the stack. If both have equal sizes, both are destroyed. 
    If a larger positive asteroid remains, the incoming asteroid is destroyed. Otherwise, the negative asteroid survives and is pushed onto the stack.” */

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int asteroid : asteroids) {
            // Positive asteroids move right and cannot collide
            // with asteroids moving in the same direction.
            if (asteroid > 0) {
                st.push(asteroid);
            } else {
                // Resolve collisions with right-moving asteroids.
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroid)) {
                    st.pop();
                }
                // Both asteroids have equal size, so both are destroyed.
                if (!st.isEmpty() && st.peek() > 0 && st.peek() == Math.abs(asteroid)) {
                    st.pop();
                }
                // If no right-moving asteroid remains, the incoming
                // left-moving asteroid survives.
                else if (st.isEmpty() || st.peek() < 0) {
                    st.push(asteroid);
                }
                // If st.peek() is larger, the incoming asteroid is destroyed.
            }
        }
        // Convert the stack into the result array.
        int[] res = new int[st.size()];
        int i = 0;
        for (int val : st) {
            res[i++] = val;
        }
        return res;
    }
}

// Time Complexity :- O(n) amortized — each asteroid is pushed and popped at most once.
// Space Complexity :- O(n) — the stack can hold up to n asteroids.
