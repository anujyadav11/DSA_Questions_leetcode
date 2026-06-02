/*********************************************** JAVA **************************************************/

// Optimal Solution - Find the mountain peak using binary search, then perform binary search on both increasing and decreasing halves.
/* “A mountain array consists of two sorted regions. I first locate the peak using binary search, 
    then perform normal binary search on the ascending side and reverse binary search on the descending side.” */

class Solution {
    // Find the peak element in the mountain array
    public int peakIndexInMountainArray(MountainArray mountainArr) {
        int n = mountainArr.length();
        int left = 0;
        int right = n - 1;
        // Binary search for peak
        while (left < right) {
            int mid = left + (right - left) / 2;
            // We are on the increasing slope
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            }
            // We are on the decreasing slope or at peak
            else {
                right = mid;
            }
        }
        return left;
    }
    // Standard binary search on ascending sorted part
    public int binarySearch(
            MountainArray mountainArr,
            int left,
            int right,
            int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }
            else if (mountainArr.get(mid) > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
    // Binary search on descending sorted part
    public int reverseBinarySearch(
            MountainArray mountainArr,
            int left,
            int right,
            int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }
            /*
            Array is descending:
            larger values are on the left
            */
            else if (mountainArr.get(mid) > target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        // Step 1: Find peak
        int peakIndex = peakIndexInMountainArray(mountainArr);
        // Step 2: Search in increasing part
        int index = binarySearch(
                mountainArr,
                0,
                peakIndex,
                target);
        // Step 3: Search in decreasing part if needed
        if (index == -1) {
            return reverseBinarySearch(
                    mountainArr,
                    peakIndex,
                    n - 1,
                    target);
        }
        return index;
    }
}

// Time Complexity :- O(log n).
// Space Complexity :- O(1).
