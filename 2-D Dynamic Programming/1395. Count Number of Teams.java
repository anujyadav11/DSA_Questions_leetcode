/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts valid rating teams by fixing each middle element and multiplying left-smaller by right-greater counts for ascending, and their complements for descending sequences.
/* "Fixing the middle element is the key insight — it decomposes the 3-element problem into two independent counting problems. The complement trick leftGreater = mid - leftSmaller avoids a third inner loop. For O(n log n) optimization, 
    mention Binary Indexed Tree (Fenwick Tree) to count elements in ranges efficiently." */

class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        for (int mid = 1; mid < n - 1; mid++) {
            int leftSmaller = 0;
            // count elements smaller than rating[mid] to the left
            for (int i = 0; i < mid; i++)
                if (rating[i] < rating[mid]) leftSmaller++;
            int rightGreater = 0;
            // count elements greater than rating[mid] to the right
            for (int k = mid + 1; k < n; k++)
                if (rating[k] > rating[mid]) rightGreater++;
            // ascending teams: smaller left × greater right
            count += leftSmaller * rightGreater;
            // descending teams: greater left × smaller right
            int leftGreater = mid - leftSmaller;
            int rightSmaller = (n - mid - 1) - rightGreater;
            count += leftGreater * rightSmaller;
        }
        return count;
    }
}

// Time Complexity :- O(n^2).
// Space Complexity :- O(1).
