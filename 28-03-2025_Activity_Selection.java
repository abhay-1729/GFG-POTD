Problem: Activity Selection(GFG)
class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here.
        int n = start.length;
        int[][] activities = new int[n][2];

        // Step 1: Store activities as pairs and sort them by finish time
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = finish[i];
        }
        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1])); // Sort by finish time

        // Step 2: Select activities greedily
        int count = 1;  // Always select the first activity
        int lastFinish = activities[0][1];

        for (int i = 1; i < n; i++) {
            if (activities[i][0] > lastFinish) { // Non-overlapping condition
                count++;
                lastFinish = activities[i][1];
            }
        }
        return count; // Maximum number of activities
    }
}
