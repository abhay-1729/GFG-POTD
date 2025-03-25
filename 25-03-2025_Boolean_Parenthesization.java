//Problem: Boolean Parenthesization (GFG)

// User function Template for Java
class Solution {
    static int[][][] dp;  // DP table for memoization
    static int countWays(String s) {
        // code here
        int n = s.length();
        dp = new int[n][n][2]; // Initializing DP table

        // Fill DP table with -1 (uncomputed states)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < 2; k++)
                    dp[i][j][k] = -1;

        return solve(s, 0, n - 1, 1);
    }

    static int solve(String s, int i, int j, int isTrue) {
        // Base Case: Single character evaluation
        if (i == j) {
            if (isTrue == 1) return s.charAt(i) == 'T' ? 1 : 0;
            else return s.charAt(i) == 'F' ? 1 : 0;
        }

        // If already computed, return stored result
        if (dp[i][j][isTrue] != -1) return dp[i][j][isTrue];

        int ways = 0;
        for (int k = i + 1; k < j; k += 2) { // k is the operator index
            char op = s.charAt(k);

            // Recursively compute left and right expressions
            int LT = solve(s, i, k - 1, 1);
            int LF = solve(s, i, k - 1, 0);
            int RT = solve(s, k + 1, j, 1);
            int RF = solve(s, k + 1, j, 0);

            // Apply operator logic
            if (op == '&') {
                if (isTrue == 1) ways += LT * RT;
                else ways += (LT * RF) + (LF * RT) + (LF * RF);
            } else if (op == '|') {
                if (isTrue == 1) ways += (LT * RT) + (LT * RF) + (LF * RT);
                else ways += (LF * RF);
            } else if (op == '^') {
                if (isTrue == 1) ways += (LT * RF) + (LF * RT);
                else ways += (LT * RT) + (LF * RF);
            }
        }

        // Store and return the result
        return dp[i][j][isTrue] = ways;
    }
}
