// Problem : Subset Sum Problem(GFG)


class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean[] prev = new boolean[sum + 1];
        boolean[] curr = new boolean[sum + 1];
        prev[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j < arr[i - 1]) {
                    curr[j] = prev[j];
                }
                else {
                    curr[j]
                        = prev[j] || prev[j - arr[i - 1]];
                }
            }
            System.arraycopy(curr, 0, prev, 0, sum + 1);
        }
        return prev[sum];
    }
}
