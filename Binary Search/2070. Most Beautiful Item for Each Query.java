/*********************************************** JAVA **************************************************/

// Optimal Solution - Answers maximum beauty queries by precomputing prefix max beauty on price-sorted items and binary searching for the rightmost affordable item per query.
/* "The prefix max transforms a 2D search into a simple binary search — after sorting by price and propagating max beauty forward, 
    any query just needs the rightmost item within budget since its beauty already reflects the best seen so far. This avoids sorting queries and using offline processing." */

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int m = queries.length;
        int[] res = new int[m];
        // sort items by price for prefix max and binary search
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        // build prefix maximum beauty — items[i][1] becomes max beauty up to price i
        int maxBeautySeen = items[0][1];
        for (int i = 1; i < n; i++) {
            maxBeautySeen = Math.max(maxBeautySeen, items[i][1]);
            items[i][1] = maxBeautySeen;
        }
        // answer each query independently using binary search
        for (int i = 0; i < m; i++)
            res[i] = customBinarySearch(items, queries[i]);
        return res;
    }
    public int customBinarySearch(int[][] items, int queryPrice) {
        int left = 0;
        int right = items.length - 1;
        int maxBeauty = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (items[mid][0] > queryPrice) {
                // price too high — search left half
                right = mid - 1;
            } else {
                // price within budget — update max beauty and search right for better
                maxBeauty = Math.max(maxBeauty, items[mid][1]);
                left = mid + 1;
            }
        }
        // return max beauty achievable within queryPrice budget
        return maxBeauty;
    }
}

// Time Complexity :- O(n log n + m log n). sorting + binarySearch on items.
// Space Complexity :- O(m). size of res array
