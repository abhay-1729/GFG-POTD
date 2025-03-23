//Problem: Total Decoding Messages (GFG)

class Solution {
    public int countWays(String digits) {
        // code here
          
        int n = digits.length();
        if (n == 0 || digits.charAt(0) == '0') 
            return 0; // If starting with '0', return 0
        
        int[] dp = new int[n + 1]; // dp[i] represents ways to decode substring of length i
        dp[0] = 1; // Empty string has one way to decode
        dp[1] = digits.charAt(0) != '0' ? 1 : 0; // First digit must be valid

        for (int i = 2; i <= n; i++) {
            char current = digits.charAt(i - 1);
            char previous = digits.charAt(i - 2);
            
            // Single digit case (1-9)
            if (current >= '1' && current <= '9') {
                dp[i] += dp[i - 1];
            }

            // Two-digit case (10-26)
            int twoDigit = (previous - '0') * 10 + (current - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
