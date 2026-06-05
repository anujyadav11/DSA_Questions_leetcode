/*********************************************** JAVA **************************************************/

// Optimal Solution - Generates all valid word-break sentences using memoised backtracking, combining dictionary prefixes with recursively solved remaining substrings.
/*  "Five bugs in one solution — typo (isEmmpty), invalid syntax ({""}), uninitialized array, wrong index, wrong return type. Always use List<String> not arrays for dynamic accumulation. 
    Memoisation is critical here — without it, overlapping subproblems cause exponential blowup. The empty string base case returning [''] acts as a seed for building complete sentences." */

class Solution {
    Set<String> set = new HashSet<>();
    // memoization map — stores results for already computed substrings
    Map<String, List<String>> memo = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        set.addAll(wordDict);
        return solve(s);
    }
    public List<String> solve(String s) {
        // base case: empty string — return list with empty string as seed
        if (s.isEmpty())
            return new ArrayList<>(Arrays.asList(""));
        // return cached result if available
        if (memo.containsKey(s))
            return memo.get(s);
        List<String> res = new ArrayList<>();
        for (int l = 1; l <= s.length(); l++) {
            String currWord = s.substring(0, l);
            if (set.contains(currWord)) {
                String remainWord = s.substring(l);
                List<String> remRes = solve(remainWord);
                // combine current word with each result from the remaining string
                for (String w : remRes) {
                    res.add(currWord + (w.isEmpty() ? "" : " " + w));
                }
            }
        }
        // cache result before returning
        memo.put(s, res);
        return res;
    }
}

// Time Complexity :- O(n² × 2^n).-worst case without memoization; memoization significantly reduces repeated work
// Space Complexity :- O(n × 2^n).— memo stores all valid sentences per substring
