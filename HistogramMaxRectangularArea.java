
//Problem: Histogram Max Rectangular Area

class Solution {
    public static int getMaxArea(int arr[]) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : arr[i];
            while (!stack.isEmpty() && currHeight < arr[stack.peek()]) {
                int height = arr[stack.pop()];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
