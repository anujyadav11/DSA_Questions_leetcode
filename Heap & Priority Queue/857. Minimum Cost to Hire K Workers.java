/*********************************************** JAVA **************************************************/

// Optimal Solution - Minimizes worker hiring cost by sorting on wage/quality ratio and using a max heap to maintain k minimum quality workers for each potential captain.
/*  "The key insight is that in any valid group, everyone is paid proportionally to their quality at the captain's ratio. So total cost = ratio × totalQuality. Sort by ratio 
    — each worker as captain, greedily pick k-1 lowest quality coworkers using a max heap. The heap's max removal keeps only the k smallest qualities, minimizing total quality sum." */
 
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = wage.length;
        // store (wage/quality ratio, quality) for each worker
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++)
            workers[i] = new double[] { (double) wage[i] / quality[i], quality[i] };
        // sort by wage/quality ratio — captain with lowest ratio minimizes cost
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        // max heap to track k smallest quality values
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double qSum = 0, res = Double.MAX_VALUE;
        for (double[] work : workers) {
            // add current worker's quality to pool
            qSum += work[1];
            pq.offer(work[1]);
            // maintain exactly k workers — remove highest quality if exceeded
            if (pq.size() > k)
                qSum -= pq.poll();
            // current worker is captain — cost = sum of k qualities * captain's ratio
            if (pq.size() == k)
                res = Math.min(res, qSum * work[0]);
        }
        return res;
    }
}

// Time Complexity :- O(n log n + n log k).
// Space Complexity :- O(n + k).
