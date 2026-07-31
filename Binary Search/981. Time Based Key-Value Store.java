/************************************************ JAVA ***********************************************/

// Optimal solution -  We store each key’s values with increasing timestamps and use binary search to efficiently retrieve the value 
                    // associated with the largest timestamp less than or equal to the given time.

class TimeStampValue {
    int timeStamp;
    String value;
    TimeStampValue(int timeStamp, String value) {
        this.timeStamp = timeStamp;
        this.value = value;
    }
}
class TimeMap {
    // maps key to sorted list of (timestamp, value) pairs
    Map<String, List<TimeStampValue>> entriesByKey;
    public TimeMap() {
        entriesByKey = new HashMap<>();
    }
    public void set(String key, String value, int timestamp) {
        // computeIfAbsent cleaner than containsKey + put
        entriesByKey.computeIfAbsent(key, k -> new ArrayList<>())
                    .add(new TimeStampValue(timestamp, value));
    }
    public String get(String key, int timestamp) {
        if (!entriesByKey.containsKey(key)) return "";
        List<TimeStampValue> entries = entriesByKey.get(key);
        // find largest timestamp <= target
        int idx = binarySearch(entries, timestamp);
        return idx == -1 ? "" : entries.get(idx).value;
    }
    // returns index of largest timestamp <= target, or -1 if none exists
    private int binarySearch(List<TimeStampValue> arr, int target) {
        int left = 0, right = arr.size() - 1;
        int matchIdx = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int ts = arr.get(mid).timeStamp;
            if (ts == target) {
                return mid;
            } else if (ts < target) {
                // valid candidate — record and search right for closer match
                matchIdx = mid;
                left = mid + 1;
            } else {
                //timestamp too large — search left
                right = mid - 1;
            }
        }
        return matchIdx;
    }
}

// Time Complexity :- O(log n).
// Space Complexity :- O(n).
