/*********************************************** JAVA **************************************************/

// Optimal Solution - Counts music playlists using 2D memoized DP tracking songs played and unique songs used, with constraints on new vs repeated song selection.
/* The DP transition captures two exclusive choices: add new song (reduces remaining unique count) or replay old song (must skip last K played, giving countUnique - K valid choices)." */

class Solution {
    private final int MOD = 1_000_000_007;
    int N, GOAL, K;
    // t[count_song][count_unique] = ways to fill playlist
    private long[][] t;
    public long solve(int countSong, int countUnique) {
        // base case: playlist complete
        if (countSong == GOAL)
            return countUnique == N ? 1 : 0;
        // return cached result
        if (t[countSong][countUnique] != -1)
            return t[countSong][countUnique];
        long res = 0;
        // add a new unique song — N - countUnique choices
        if (countUnique < N)
            res += (long)(N - countUnique) * solve(countSong + 1, countUnique + 1);
        // replay an old song — must not have been played in last K songs
        if (countUnique > K)
            res += (long)(countUnique - K) * solve(countSong + 1, countUnique);
        return t[countSong][countUnique] = res % MOD;
    }
    public int numMusicPlaylists(int n, int goal, int k) {
        t = new long[goal + 1][n + 1];
        for (long[] row : t)
            Arrays.fill(row, -1L);
        N = n;
        GOAL = goal;
        K = k;
        return (int) solve(0, 0);
    }
}

// Time Complexity :- O(goal * n).
// Space Complexity :- O(goal * n).
