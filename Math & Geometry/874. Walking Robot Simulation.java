/*********************************************** JAVA **************************************************/

// Optimal Solution - Simulates robot navigation using a direction array and obstacle HashMap, tracking maximum squared distance from origin after each move command.
/* "(curDir + 3) % 4 is the clean left-turn formula — adding 3 is equivalent to subtracting 1 in modular arithmetic, avoiding negative modulo issues. 
    HashMap with x-to-y-set mapping gives O(1) obstacle lookup vs O(m) linear scan per step. Always update res after completing a full command, not after each step." */

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // directions: North, East, South, West (clockwise order)
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] curPos = {0, 0};
        int res = 0;
        int curDir = 0;
        // map x coordinate to set of y coordinates for O(1) obstacle lookup
        Map<Integer, Set<Integer>> obsMap = new HashMap<>();
        for (int[] obs : obstacles)
            obsMap.computeIfAbsent(obs[0], k -> new HashSet<>()).add(obs[1]);
        for (int cmd : commands) {
            if (cmd == -1) {
                // turn right — clockwise
                curDir = (curDir + 1) % 4;
                continue;
            }
            if (cmd == -2) {
                // turn left — counter-clockwise
                curDir = (curDir + 3) % 4;
                continue;
            }
            int[] dir = directions[curDir];
            for (int step = 0; step < cmd; step++) {
                int nextX = curPos[0] + dir[0];
                int nextY = curPos[1] + dir[1];
                // stop if next cell has an obstacle
                if (obsMap.containsKey(nextX) && obsMap.get(nextX).contains(nextY))
                    break;
                curPos[0] = nextX;
                curPos[1] = nextY;
            }
            // update max squared distance after each command
            res = Math.max(res, curPos[0] * curPos[0] + curPos[1] * curPos[1]);
        }
        return res;
    }
}

// Time Complexity :- O(n + m). — n = total steps across all commands, m = obstacles for HashMap build
// Space Complexity :- O(m). — obstacle HashMap
