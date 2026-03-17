/*********************************************** JAVA **************************************************/

// Optimal Solution - Use a greedy approach to prioritize giving $10+$5 change for $20 bills to maintain optimal flexibility.
/* "This is a greedy problem where we always try to give change in a way that preserves smaller denominations, especially $5 bills, since they are essential for future transactions." */

class Solution {
    public boolean lemonadeChange(int[] bills) {
        // Initialize variables to keep track of available change
        int five = 0, ten = 0;
        // Iterate through each bill in the array
        for(int i : bills) {
            // Process each bill
            if(i == 5) // If the bill is $5
                five++; // Increment the count of $5 bills
            else if(i == 10) { // If the bill is $10
                five--; // Decrement the count of $5 bills
                ten++; // Increment the count of $10 bills
            }
            else if(ten > 0) { // If the bill is $20 and we have at least one $10 bill
                five--; // Use one $10 bill
                ten--; // Use one $5 bill
            }
            else // If the bill is $20 and we don't have a $10 bill
                five -= 3; // Use three $5 bills
            // Check if we have enough change
            if(five < 0) // If we have negative $5 bills, return false
                return false;
        }
        // If we processed all bills successfully, return true
        return true;
    }
}

// Time Complexity :- O(n).
// Space Complexity :- O(1).
