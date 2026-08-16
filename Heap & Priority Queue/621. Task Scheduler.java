/*********************************************** JAVA **************************************************/

// Optimal Solution - Schedule tasks using a max-heap by executing the most frequent tasks first in fixed cycles of size (n + 1) to minimise idle time.

class Solution {
    public int leastInterval(char[] tasks, int p) {
        // Count frequency of each task
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }
        // Max-heap: most frequent task comes first
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());
        for (int count : freq) {
            if (count > 0) {
                pq.offer(count);
            }
        }
        int time = 0;
        while (!pq.isEmpty()) {
            // One cycle can contain p + 1 tasks
            int cycle = p + 1;
            // Store remaining frequencies after this cycle
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;
            while (cycle-- > 0 && !pq.isEmpty()) {
                // Execute the most frequent remaining task
                int currentFreq = pq.poll();
                // One occurrence is completed
                if (currentFreq > 1) {
                    store.add(currentFreq - 1);
                }
                taskCount++;
            }
            // Put remaining tasks back into the heap
            for (int count : store) {
                pq.offer(count);
            }
            // If tasks remain, the entire cycle is required.
            // Otherwise, only count the tasks actually executed.
            time += pq.isEmpty() ? taskCount : p + 1;
        }
        return time;
    }
}

// Time Complexity :- O(N).
// Space Complexity :- O(1).
