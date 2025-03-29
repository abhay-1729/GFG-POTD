//Problem: Job Sequencing Problem (GFG)
class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;
        int[][] jobs = new int[n][2];

        // Step 1: Store jobs as pairs and sort them by profit in descending order
        for (int i = 0; i < n; i++) {
            jobs[i][0] = deadline[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> Integer.compare(b[1], a[1])); // Sort by profit (descending)

        // Step 2: Find the maximum deadline to create slots
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i][0]);
        }

        // Step 3: Use a slot array to mark available slots (default -1 means empty)
        int[] slots = new int[maxDeadline + 1]; // 1-based indexing
        Arrays.fill(slots, -1);

        int countJobs = 0, maxProfit = 0;

        // Step 4: Try to place jobs in the latest possible slot before their deadline
        for (int i = 0; i < n; i++) {
            int jobDeadline = jobs[i][0];
            int jobProfit = jobs[i][1];

            // Find the latest available slot from jobDeadline to 1
            for (int j = jobDeadline; j > 0; j--) {
                if (slots[j] == -1) { // If slot is empty, assign this job
                    slots[j] = i;
                    countJobs++;
                    maxProfit += jobProfit;
                    break;
                }
            }
        }

        // Step 5: Return results
        ArrayList<Integer> result = new ArrayList<>();
        result.add(countJobs);
        result.add(maxProfit);
        return result;
    }
}
