/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds minimum balloon removal cost by greedily keeping the most expensive balloon in each consecutive same-colour group using a two-pointer window.

/* "For consecutive duplicate groups, always keep the maximum cost element — that minimises what you remove. The two-pointer approach tracks the current group anchor at left, comparing against right and accumulating the cheaper cost. 
    Colour change resets the window since a new group begins." */

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res = 0;
        // left anchors the current group of same-colored balloons
        int left = 0;
        for (int right = 1; right < colors.length(); right++) {
            if (colors.charAt(left) == colors.charAt(right)) {
                // same color — remove the cheaper one, keep the more expensive
                if (neededTime[left] < neededTime[right]) {
                    // left is cheaper — add its cost and move left to right
                    res += neededTime[left];
                    left = right;
                } else {
                    // right is cheaper — add its cost, left stays as group anchor
                    res += neededTime[right];
                }
            } else {
                // different colour — no removal needed, shift window
                left = right;
            }
        }
        // return minimum total removal cost
        return res;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).
