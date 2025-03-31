//problem: Maximize partitions in a String(GFG)
class Solution {
    public int maxPartitions(String s) {
        // code here
        int n = s.length();
        int[] lastIndex = new int[26];

        // Step 1: Store last occurrence index for each character
        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        // Step 2: Traverse and create partitions
        int end = 0, count = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if (i == end) {
                count++; // A partition is formed
            }
        }
        return count;
    }
}
