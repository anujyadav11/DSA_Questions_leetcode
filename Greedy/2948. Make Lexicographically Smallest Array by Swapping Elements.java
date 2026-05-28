/*********************************************** JAVA **************************************************/

// Optimal Solution - Produces lexicographically smallest array by grouping swappable elements within limit distance and greedily assigning smallest group values to original positions.
/* "The key insight is transitivity — if A can swap with B and B can swap with C (all within limit), then A, B, C form one group and any permutation is achievable among their positions. 
    Sorting identifies these groups by consecutive gap checking. Using a deque (queue) ensures smallest values are assigned first when iterating left to right." */

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        // create sorted copy to group elements within limit distance
        int[] temp = new int[n];
        for (int i = 0; i < n; i++)
            temp[i] = nums[i];
        Arrays.sort(temp);
        // each group holds sorted values that can be swapped among themselves
        List<Deque<Integer>> list = new ArrayList<>();
        // maps each value to its group index
        Map<Integer, Integer> group = new HashMap<>();
        int groupIdx = 0;
        list.add(new LinkedList<>());
        list.get(groupIdx).offer(temp[0]);
        group.put(temp[0], groupIdx);
        for (int i = 1; i < n; i++) {
            // start new group if gap exceeds limit
            if (temp[i] - list.get(groupIdx).peekLast() > limit) {
                groupIdx++;
                list.add(new LinkedList<>());
            }
            group.put(temp[i], groupIdx);
            list.get(groupIdx).offer(temp[i]);
        }
        // replace each original element with smallest available in its group
        for (int i = 0; i < n; i++) {
            int gi = group.get(nums[i]);
            nums[i] = list.get(gi).poll();
        }
        return nums;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(n).
