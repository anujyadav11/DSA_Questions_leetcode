/*********************************************** JAVA **************************************************/

// Optimal Solution - Reconstructs deck reveal order by simulating index queue rotation, assigning sorted cards to positions in the order they would be revealed.
/* "que.offer(que.poll()) is the standard queue rotation idiom — always use it as one expression to avoid the duplicate-element bug of separating peek/offer/poll. 
    The insight is simulating the process backwards using indices — assign smallest card to next 'would-be-revealed' position, then rotate to skip the next index mimicking the discard." */

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        // simulate index queue — tracks which position gets filled next
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++)
            que.offer(i);
        int[] res = new int[n];
        // sort deck so smallest cards are assigned first
        Arrays.sort(deck);
        for (int i = 0; i < n; i++) {
            // assign next smallest card to next revealed position
            res[que.poll()] = deck[i];
            if (!que.isEmpty())
                // rotate — move front index to back
                que.offer(que.poll());
        }
        return res;
    }
}

// Time Complexity :- O(n log n).
// Space Complexity :- O(n).
