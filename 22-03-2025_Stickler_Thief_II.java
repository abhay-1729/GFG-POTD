//Problem: Stickler Thief II
class Solution {
    int maxValue(int[] arr) {
        // code here
        int n = arr.length;
        if (n == 1) return arr[0]; // If only one house, return its value
        
        // Case 1: Exclude last house, consider range [0, n-2]
        int case1 = houseRobber(arr, 0, n - 2);
        
        // Case 2: Exclude first house, consider range [1, n-1]
        int case2 = houseRobber(arr, 1, n - 1);

        // Maximum of both cases
        return Math.max(case1, case2);
    }

    private int houseRobber(int[] arr, int start, int end) {
        int prev2 = 0, prev1 = 0;
        
        for (int i = start; i <= end; i++) {
            int take = arr[i] + prev2;
            int skip = prev1;
            int curr = Math.max(take, skip);
            
            // Update prev2 and prev1
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}
