// Simply using sort function and lambda expression to sort the logs as per the requirement.

// Time Complexity : O(nlogn)
// Space Complexity : O(k) k is the strarray split
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // Base case
        if (logs == null || logs.length == 0) {
            return logs;
        }
        // Use the sort function
        Arrays.sort(logs, (log1, log2) -> {
            // Between any two logs; log1 ang log2
            // Split them in two parts - first is the identifier and second is the content
            String[] strlog1 = log1.split(" ", 2);
            String[] strlog2 = log2.split(" ", 2);
            // Check if the log is a digit log or a letter log
            boolean isDigit1 = Character.isDigit(strlog1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(strlog2[1].charAt(0));
            // If both are letter logs
            if (!isDigit1 && !isDigit2) {
                // Sort them based on the content
                int cmp = strlog1[1].compareTo(strlog2[1]);
                // If content is same
                if (cmp == 0) {
                    // Sort them based on the identifier
                    return strlog1[0].compareTo(strlog2[0]);
                }
                return cmp;
            }
            // If first is digit log and second is letter log
            else if (isDigit1 && !isDigit2) {
                // Keep letter log first
                return 1;
            }
            // If first is letter log and second is digit log
            else if (!isDigit1 && isDigit2) {
                // No need to change
                return -1;
            }
            // If both digit logs
            else {
                // Keep same order
                return 0;
            }
        });
        // Return the sorted logs
        return logs;
    }

}