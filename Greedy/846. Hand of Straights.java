/*********************************************** JAVA **************************************************/

//Optimal Solution - Greedy approach using a TreeMap to repeatedly form consecutive groups starting from the smallest card. Starting from the smallest card is optimal because skipping it would prevent forming a valid consecutive sequence later.
/* “I count the frequency of every card and store them in a sorted map. The smallest remaining card must be the start of the next group, because there is no smaller card available to place before it. 
    I therefore greedily consume groupSize consecutive cards starting from the smallest card. If any required card is missing, forming the groups is impossible.” */

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        // If total cards cannot be evenly divided into groups
        if (n % groupSize != 0) {
            return false;
        }
        // TreeMap to store card value -> frequency (keeps keys sorted)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // Count frequency of each card
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        // Process cards until all are used
        while (!map.isEmpty()) {
            // Always start from the smallest available card
            int curr = map.firstKey();
            // Try to form a group of size 'groupSize'
            for (int i = 0; i < groupSize; i++) {
                // If a required consecutive card is missing
                if (!map.containsKey(curr + i)) {
                    return false;
                }
                // Use one occurrence of the card
                map.put(curr + i, map.get(curr + i) - 1);
                // Remove card if its frequency becomes zero
                if (map.get(curr + i) == 0) {
                    map.remove(curr + i);
                }
            }
        }
        return true;
    }
}


// Time Complexity :- O(n lgo n).
// Space Complexity :- O(n).
