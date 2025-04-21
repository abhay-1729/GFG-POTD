//Problem: Missing in Array(gfg_)
class Solution {
    int missingNum(int arr[]) {
        // code here
        int i = 0;
        int n = arr.length + 1; // Total numbers should be n (including missing one)

        // XOR all numbers from 1 to n
        for (int j = 1; j <= n; j++) {
            i = i ^ j;
        }
        
        // XOR all elements of array
        for (int num : arr) {
            i = i ^ num;
        }
        
        return i;
    }
}
