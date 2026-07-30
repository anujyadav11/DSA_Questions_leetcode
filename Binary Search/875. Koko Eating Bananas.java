/*********************************************** JAVA **************************************************/

// Optimal Solution - Finds minimum eating speed using binary search on speed range, verifying feasibility via ceiling-division hour accumulation across all piles.
/* "Ceiling division (pile + speed - 1) / speed is the integer alternative to Math.ceil((double)pile/speed) — avoids floating point and is slightly faster. 
    Binary search on answer works because feasibility is monotonic — if speed k works, any speed > k also works. 
    Upper bound is maxPile since eating at that speed finishes any pile in exactly 1 hour." */

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;
        // upper bound = largest pile (can finish any pile in 1 hour)
        for (int pile : piles)
            maxSpeed = Math.max(maxSpeed, pile);
        // binary search for minimum valid speed
        while (minSpeed < maxSpeed) {
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;
            if (canEat(piles, h, mid))
                maxSpeed = mid;
            else
                minSpeed = mid + 1;
        }
        return minSpeed;
    }
    public boolean canEat(int[] piles, int h, int speed) {
        int hours = 0;
        for (int pile : piles)
            // ceiling division — partial pile still takes 1 hour
            hours += (int) Math.ceil((double) pile / speed);
        return hours <= h;
    }
}

// Time Complexity :- O(n log maxPile). — binary search over speed range, each check is O(n)
// Space Complexity :- O(1).
