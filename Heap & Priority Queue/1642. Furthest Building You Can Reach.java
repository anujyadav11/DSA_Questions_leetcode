/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds the furthest reachable building using a greedy max-heap strategy — spending bricks on all climbs and retroactively swapping the largest climbs to ladders when bricks run out.
/* "The greedy insight is that ladders should cover the largest climbs — but we don't know future climbs. So greedily use bricks everywhere, and when bricks run out, 
    retroactively swap the most expensive climb to a ladder using the max heap. poll() vs peek() is a classic bug — always verify you're actually removing the element when consuming it." */

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // max heap tracks all climbs made so far — largest on top
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            // no climb needed — move forward freely
            if (diff <= 0)
                continue;
            // use bricks for this climb
            bricks -= diff;
            pq.add(diff);
            if (bricks < 0) {
                // out of bricks — replace largest climb with a ladder
                // poll() to remove the largest climb from heap
                bricks += pq.poll();
                if (ladders > 0)
                    ladders--;
                else
                    // no ladders left — can't proceed
                    return i;
            }
        }
        // reached the last building
        return heights.length - 1;
    }
}

// Time Complexity :- O(n log L). — each climb added/removed from the heap of size at most L (ladders used).
// Space Complexity :- O(L). — heap holds at most L elements.
