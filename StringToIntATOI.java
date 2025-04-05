// In this problem, first for handling the edge cases, doing s.trim to remove all the spaces. Then checking if the first char is sign
// storing that in sign variable. Then if the first char is not any sign and is not any digit also then returning 0. Then iterating
// through each digit in s, checking if it's not a digit break, else convert to int and put in num. Before adding extra digit to the
// num, checking if the num value is already greater than the limit ( limit we have a set to integer.max val after removing the last
// digit from it. So before going out of bounds only we check if the num is greater we return max value, else if it is exactly same as
// limit we check for the incoming digit, for +infinity digit should be <7, and for - it should be <8). Same we do for -infinity.
// After this we construct the num by adding the incoming digit.

// Time Complexity : O(n) // For trim
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int myAtoi(String s) {
        // Remove the spaces
        s = s.trim();
        // Then check if the length is 0 or it is null, return 0
        if (s == null || s.length() == 0) {
            return 0;
        }
        // Take one sign variable
        char sign = '+';
        // Check if the first char is -, then change the sign
        if (s.charAt(0) == '-') {
            sign = '-';
        }
        // Check if it is none of the signs and it is also not a digit (can be a char
        // a-z), so return 0
        if (s.charAt(0) != '+' && s.charAt(0) != '-' && !Character.isDigit(s.charAt(0))) {
            return 0;
        }
        // Take num to form our integer
        int num = 0;
        // Take the limit (max=2147483647, min=2147483648 so limit=214748364) so we
        // remove last digit, not limit for both max and min will be same because only
        // last digits differs
        int limit = Integer.MAX_VALUE / 10;
        // Loop
        for (int i = 0; i < s.length(); i++) {
            // Take the char
            char c = s.charAt(i);
            // If it is a digit
            if (Character.isDigit(c)) {
                // Check the sign
                if (sign == '+') {
                    // If the num value is greater than limit and we add a incoming char c, it will
                    // be out of bounds
                    // Or if the num value is exactly equal to limit, we check if the incoming digit
                    // for + sign should not be >=7
                    if (num > limit || (num == limit && (c - '0') >= 7)) {
                        // If either is true, we simply return max value
                        return Integer.MAX_VALUE;
                    }
                } else {
                    // Same we do for negative infinity, only difference not the int.min value has
                    // last digit 8, so we check if incoming char is >=8, we return min value
                    if (num > limit || (num == limit && (c - '0') >= 8)) {
                        return Integer.MIN_VALUE;
                    }
                }
                // Else add the incoming digit to the num
                num = num * 10 + (c - '0');
            } else {
                // If it is not a digit and we are also not at first index, we break
                if (i != 0) {
                    break;
                }
            }
        }
        // Return num as per sign
        if (sign == '-') {
            return -num;
        }
        return num;
    }
}