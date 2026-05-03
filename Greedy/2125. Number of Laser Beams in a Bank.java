/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts laser beams by multiplying device counts between consecutive non-empty bank rows, skipping empty rows by preserving previous valid count.
/* "The beam count between two rows is simply their product — every device in row i connects to every device in row j. Empty rows are transparent — they don't reset the previous count. 
    The ternary/if for skipping empty rows is the only non-obvious part — worth explaining clearly to the interviewer." */

class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int prevDeviceCount = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // count security devices in current row
            int currDeviceCount = 0;
            for (char ch : bank[i].toCharArray())
                if (ch == '1')
                    currDeviceCount++;
            // beams = product of devices in consecutive non-empty rows
            res += currDeviceCount * prevDeviceCount;
            // skip empty rows — keep previous non-empty row count
            if (currDeviceCount != 0)
                prevDeviceCount = currDeviceCount;
        }
        return res;
    }
}

// Time Complexity :- O(n * m).
// Space Complexity :- O(1).
