/*********************************************** JAVA **************************************************/

// Optimal Solution - Use arithmetic progression to compute weekly savings pattern in constant time.
/* "The pattern forms an arithmetic progression across weeks, so I compute full weeks using AP formula and then handle remaining days separately." */

class Solution {
    public int totalMoney(int n) {
        // Number of complete weeks
        int weeks = n / 7;
        // Sum of first week (1+2+3+4+5+6+7 = 28)
        int firstWeekSum = 28;
        // Last week's sum increases by 7 each week
        int lastWeekSum = 28 + (weeks - 1) * 7;
        // Sum of all complete weeks using arithmetic progression formula
        int total = weeks * (firstWeekSum + lastWeekSum) / 2;
        // Remaining days after full weeks
        int remainingDays = n % 7;
        // Starting value for remaining days (next Monday value)
        int start = 1 + weeks;
        // Ending value for remaining days
        int end = start + remainingDays - 1;
        // Add sum of remaining days (again AP formula)
        total += remainingDays * (start + end) / 2;
        return total;
    }
}

// Time Complexity :- O(1).
// Space Complexity :- O(1).
