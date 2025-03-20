//Problem: Stock Buy and Sell – Max 2 Transactions Allowed(GFG)

class Solution {
    public static int maxProfit(int[] prices) {
        // code here
          int n = prices.length;
        if (n == 0) return 0;

        // Arrays to store max profit for one transaction in both directions
        int[] leftProfit = new int[n];
        int[] rightProfit = new int[n];

        // Forward Pass: Compute max profit if selling on or before day i
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
        }

        // Backward Pass: Compute max profit if buying on or after day i
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
        }

        // Combine the two parts
        int maxTotalProfit = 0;
        for (int i = 0; i < n; i++) {
            maxTotalProfit = Math.max(maxTotalProfit, leftProfit[i] + rightProfit[i]);
        }

        return maxTotalProfit;
    }
}
