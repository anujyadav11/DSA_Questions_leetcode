/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds smallest range covering all lists using a min heap maintaining one element per list, always advancing the minimum list to shrink the range window.
/* "The invariant is exactly one element per list in the heap — this guarantees the range covers all lists. Advancing the minimum is greedy — the minimum defines the left boundary, 
    and only replacing it can reduce the range. Advancing any other element would increase or maintain the left boundary but potentially increase the right, giving a worse range." */

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // min heap stores (value, listIndex, elementIndex)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int curMax = Integer.MIN_VALUE;
        // initialize heap with first element of each list
        for (int i = 0; i < nums.size(); i++) {
            minHeap.offer(new int[]{nums.get(i).get(0), i, 0});
            curMax = Math.max(curMax, nums.get(i).get(0));
        }
        int[] smallRange = new int[]{0, Integer.MAX_VALUE};
        while (true) {
            // poll minimum element — defines left boundary of current range
            int[] curr = minHeap.poll();
            int curMin = curr[0], listIdx = curr[1], elemIdx = curr[2];
            // update range if current window [curMin, curMax] is smaller
            if (curMax - curMin < smallRange[1] - smallRange[0]) {
                smallRange[0] = curMin;
                smallRange[1] = curMax;
            }
            // advance to next element in same list
            if (elemIdx + 1 < nums.get(listIdx).size()) {
                int nextVal = nums.get(listIdx).get(elemIdx + 1);
                minHeap.offer(new int[]{nextVal, listIdx, elemIdx + 1});
                // update global max with new element
                curMax = Math.max(curMax, nextVal);
            } else {
                // list exhausted — cannot cover all lists anymore
                break;
            }
        }
        return smallRange;
    }
}

// Time Complexity :- O(n log k).
// Space Complexity :- O(k).
