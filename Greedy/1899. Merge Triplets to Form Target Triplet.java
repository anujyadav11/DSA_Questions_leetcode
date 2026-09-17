/*********************************************** JAVA **************************************************/

// Optimal Solution - Greedy solution that validates whether the target triplet can be formed by combining valid triplets without exceeding the target values. I ignore invalid triplets and greedily track which target coordinates can be matched; if all three are covered, the merge is possible.
/* “Since merging takes the maximum value at each coordinate, any triplet containing a value greater than the corresponding target can never be used. I discard those triplets. For every remaining triplet, 
    I record which coordinates exactly match the target. If all three coordinates can be matched across the valid triplets, their coordinate-wise maximum can form the target.” */

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> good = new HashSet<>();
        for (int[] t : triplets) {
            // Ignore triplets that would exceed the target
            // because merging can only take maximum values.
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2])
                continue;
            // Track which target positions can be achieved.
            for (int i = 0; i < t.length; i++) {
                if (t[i] == target[i]) {
                    good.add(i);
                }
            }
        }
        // We need to achieve all three target positions.
        return good.size() == 3;
    }
}
// Time Complexity :- O(N).
// Space Complexity :- O(1).
