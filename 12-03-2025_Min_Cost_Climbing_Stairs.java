//Probelm: Mic Cost Climbing Stairs(GFG)

class Solution {
    static int minCostClimbingStairs(int[] cost) {
        // Write your code here
         int n = cost.length;
        if (n == 2) 
            return Math.min(cost[0], cost[1]);
        int prev2 = cost[0], prev1 = cost[1], current = 0;
        for (int i = 2; i < n; i++) {
            current = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = current;
        }
        return Math.min(prev1, prev2);
    }
};
