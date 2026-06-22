/************************************************* JAVA ******************************************/

//Optimal Approach - using HashMap as frequency and using bucket sort for finding top k frequent element 

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Create an array of Lists to use as buckets for frequency values.
        List<Integer>[] bucket = new List[nums.length + 1];
        // Create a HashMap to store the frequency of each number.
        Map<Integer, Integer> freq = new HashMap<>();
        // Count the frequency of each number in the input array.
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        // Populate the buckets with numbers based on their frequencies.
        for (int key : freq.keySet()) {
            int freq1 = freq.get(key);
            if (bucket[freq1] == null) {
                bucket[freq1] = new ArrayList<>();
            }
            bucket[freq1].add(key);
        }
        // Create an array to store the result.
        int[] res = new int[k];
        int counter = 0;
        // Iterate through the buckets in reverse order to find the top k frequent numbers.
        for (int pos = bucket.length - 1; pos >= 0 && counter < k; pos--) {
            if (bucket[pos] != null) {
                for (Integer integer : bucket[pos]) {
                    res[counter++] = integer;
                }
            }
        }
        return res;
    }
}

// Time Complexity :- O(n)
// Space Complexity :- O(n)

// Better Solution - using HashMap as frequency and min-heap to store the k most frequent elements

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Stores the final k most frequent elements
        int[] result = new int[k];
        // Frequency map: number -> occurrence count
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        // Count frequencies
        for (int num : nums) {
            frequencyMap.put(num,
                    frequencyMap.getOrDefault(num, 0) + 1);
        }
        // Max Heap ordered by frequency
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>(
                        (a, b) -> b.getValue() - a.getValue()
                );
        // Add all entries to the heap
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            maxHeap.offer(entry);
        }
        // Extract k most frequent elements
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().getKey();
        }
        return result;
    }
}

// Time Complexity :- O(n log k)
// Space Complexity :- O(n)
