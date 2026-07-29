/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts car fleets by sorting positions descending and using a stack to track distinct arrival times, merging cars that catch up to the fleet ahead.
/* "Sorting descending by position is critical — we process cars from front to back so we know what's ahead. A car catches up to the fleet ahead if its arrival time ≤ the leading car's time. 
    The stack naturally maintains a monotonically increasing sequence of fleet times — each entry is a distinct fleet that couldn't catch the one ahead." */

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        // sort by position descending — process closest to target first
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for (int[] p : pair) {
            // time for this car to reach target
            double time = (double) (target - p[0]) / p[1];
            stack.push(time);
            // if current car arrives before or same time as car ahead — they merge
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2))
                stack.pop();
        }
        // each remaining stack entry represents one fleet
        return stack.size();
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(n).
