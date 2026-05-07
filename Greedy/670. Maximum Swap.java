/*********************************************** JAVA **************************************************/

// Optimal Solution - Maximizes a number with one swap by scanning right-to-left, tracking the rightmost maximum digit and recording the leftmost position that benefits from swapping with it.
/* "The greedy insight is twofold — swap the leftmost digit that's smaller than some digit to its right (maximizes place value), and use the rightmost occurrence of the maximum (breaks ties correctly). 
    Scanning right-to-left with a running max naturally captures both conditions — keep updating swapIdx1 so the leftmost beneficial position is always recorded last." */

class Solution {
    public int maximumSwap(int num) {
        char[] numArr = Integer.toString(num).toCharArray();
        int n = numArr.length;
        // track maximum element and its index from the right
        char maxEl = numArr[n - 1];
        int maxI = n - 1;
        int swapIdx1 = -1;
        int swapIdx2 = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (numArr[i] > maxEl) {
                // found new maximum — update tracker
                maxEl = numArr[i];
                maxI = i;
            } else if (numArr[i] < maxEl) {
                // current digit is smaller than max seen to its right — candidate swap
                swapIdx1 = i;
                swapIdx2 = maxI;
            }
        }
        // perform swap if a beneficial exchange was found
        if (swapIdx1 != -1) {
            char temp = numArr[swapIdx1];
            numArr[swapIdx1] = numArr[swapIdx2];
            numArr[swapIdx2] = temp;
        }
        return Integer.parseInt(new String(numArr));
    }
}

// Time Complexity :- O(d).
// Space Complexity :- O(d).
