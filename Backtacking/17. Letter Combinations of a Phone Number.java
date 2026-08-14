/*********************************************** JAVA **************************************************/

// Optimal Solution - Use backtracking to generate all possible letter combinations by exploring every character mapped to each digit of the phone keypad.
/* “I map each digit to its corresponding phone keypad letters. I use backtracking to process one digit at a time. For each digit, I try every possible character, 
    append it to the current StringBuilder, recursively process the next digit, and remove the character afterwards. When all digits are processed, the current string is a complete combination.” */

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        // No digits means no combinations
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        // Phone keypad mapping
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder temp = new StringBuilder();
        // Start building combinations from index 0
        solve(0, digits, temp, map);
        return res;
    }
    public void solve(int idx,String digits,StringBuilder temp,Map<Character, String> map) {
        // All digits processed -> complete combination
        if (idx >= digits.length()) {
            res.add(temp.toString());
            return;
        }
        // Get letters corresponding to current digit
        char ch = digits.charAt(idx);
        String str = map.get(ch);
        // Try every possible letter
        for (int i = 0; i < str.length(); i++) {
            // Choose
            temp.append(str.charAt(i));
            // Explore next digit
            solve(idx + 1, digits, temp, map);
            // Backtrack
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}

// Time Complexity: O(4^n)
// Space Complexity: O(n)  // excluding output
