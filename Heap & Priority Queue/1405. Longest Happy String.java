/*********************************************** JAVA **************************************************/

// Optimal Solution - Implemented a greedy Max Heap approach using character frequencies to construct the longest valid string without three consecutive identical characters, achieving O(a+b+c) time and O(a+b+c) auxiliary space.
/* "I use a Max Heap to prioritize the character with the highest remaining frequency. At every step, I check whether selecting that character would create three consecutive identical characters. 
    If it is safe, I append it and decrease its frequency. Otherwise, I temporarily select the second most frequent character. 
    I reinsert characters with remaining occurrences into the heap and continue until no valid character can be selected." */

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // Max Heap: stores characters based on their remaining frequency.
        // The character with the highest count is always at the top.
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // Add characters with positive frequencies to the heap.
        if (a > 0) {
            pq.offer(new Pair(a, 'a'));
        }
        if (b > 0) {
            pq.offer(new Pair(b, 'b'));
        }
        if (c > 0) {
            pq.offer(new Pair(c, 'c'));
        }
        // Stores the final happy string.
        StringBuilder res = new StringBuilder();
        // Continue until no characters are available.
        while (!pq.isEmpty()) {
            // Extract the character with the highest remaining frequency.
            Pair node = pq.poll();
            // Get the current result length.
            int n = res.length();
            // Extract the character and its remaining frequency.
            char ch = node.ch;
            int count = node.count;
            // Check whether appending this character would
            // create three consecutive identical characters.
            if (n >= 2 &&
                res.charAt(n - 1) == ch &&
                res.charAt(n - 2) == ch) {
                // If no alternative character exists,
                // we cannot append anything without violating the rule.
                if (pq.isEmpty()) {
                    break;
                }
                // Extract the second most frequent character.
                Pair sec = pq.poll();
                // Append the alternative character.
                res.append(sec.ch);
                // Decrease its remaining frequency.
                sec.count--;
                // If occurrences remain, add it back to the heap.
                if (sec.count > 0) {
                    pq.offer(new Pair(sec.count, sec.ch));
                }
            } else {
                // Appending the current character is safe.
                res.append(node.ch);
                // Decrease its remaining frequency.
                node.count--;
            }
            // Reinsert the current character if occurrences remain.
            if (node.count > 0) {
                pq.offer(new Pair(node.count, node.ch));
            }
        }
        // Return the longest valid string constructed.
        return res.toString();
    }
}
// Custom Pair class representing a character and its frequency.
class Pair implements Comparable<Pair> {
    int count;
    char ch;
    Pair(int count, char ch) {
        this.count = count;
        this.ch = ch;
    }
    // Sort in descending order of frequency.
    // Higher frequency characters receive higher priority.
    public int compareTo(Pair that) {
        return that.count - this.count;
    }
}

// Time Complexity :- O(n) - a + b + c.
// Space Complexity :- O(n) - using StringBuilder.
