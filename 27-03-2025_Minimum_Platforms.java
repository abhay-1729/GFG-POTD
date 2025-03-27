//Problem: Minimum Platforms (GFG)
class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        // Step 1: Sort the arrival and departure times
        Arrays.sort(arr); // Sort the arrival times
        Arrays.sort(dep); // Sort the departure times

        // Step 2: Initialize pointers and counters
        int i = 0;          // Pointer for arrival times
        int j = 0;          // Pointer for departure times
        int count = 0;      // To keep track of the current platforms needed
        int maxCount = 0;   // To store the maximum platforms required at any time

        // Step 3: Traverse the arrival and departure arrays
        while (i < arr.length) {
            // If the next train's arrival time is before or equal to the current train's departure time,
            // increment the platform count (a train needs a platform).
            if (arr[i] <= dep[j]) {
                count++;  // A new platform is needed
                i++;      // Move to the next arrival time
            } 
            // If the next train's arrival time is after the current train's departure time,
            // free up a platform (the train has departed).
            else {
                count--;  // A platform is freed up
                j++;      // Move to the next departure time
            }

            // Update the maximum platform count seen so far
            maxCount = Math.max(count, maxCount);
        }

        // Step 4: Return the maximum number of platforms required
        return maxCount;
    }
}
