/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts minimum swaps to sort each tree level using BFS level collection and index-mapped cycle sort, summing swaps across all levels.
/* "Minimum swaps to sort = number of elements not in their cycle position — the cycle sort approach finds this in O(n) per level using a value-to-index map. Key detail: 
    always use .equals() not == for Integer comparison in Java — == compares references and fails for values outside the -128 to 127 cache range." */

class Solution {
    public int countMinSwapsToSort(List<Integer> vec) {
        int swaps = 0;
        // create sorted version to know target positions
        List<Integer> sortedVec = new ArrayList<>(vec);
        Collections.sort(sortedVec);
        // map each value to its current index in vec
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < vec.size(); i++)
            mp.put(vec.get(i), i);
        for (int i = 0; i < vec.size(); i++) {
            // already in correct position — skip
            if (vec.get(i).equals(sortedVec.get(i))) continue;
            // find where the correct element currently is
            int currIdx = mp.get(sortedVec.get(i));
            // update map before swapping — vec.get(i) moves to currIdx
            mp.put(vec.get(i), currIdx);
            // sortedVec.get(i) moves to position i
            mp.put(sortedVec.get(i), i);
            // perform the swap in vec
            Collections.swap(vec, currIdx, i);
            swaps++;
        }
        return swaps;
    }
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int result = 0;
        while (!que.isEmpty()) {
            // collect all values at current level
            int n = que.size();
            List<Integer> vec = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode temp = que.poll();
                vec.add(temp.val);
                // enqueue children for next level
                if (temp.left != null) que.add(temp.left);
                if (temp.right != null) que.add(temp.right);
            }
            // add minimum swaps needed to sort this level
            result += countMinSwapsToSort(vec);
        }
        return result;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(n).
