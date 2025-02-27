
// Problem: Get Min from Stack
// GFG
class Solution {
    private Stack<int[]> stack;
    public Solution() {
        stack =new Stack<>();
    }
    // Add an element to the top of Stack
    public void push(int x) {
        // code here
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
        }else {
            int currentMin = stack.peek()[1];
            if (x < currentMin) {
                stack.push(new int[]{x, x});
            } else {
                stack.push(new int[]{x, currentMin});
            }
        }
    }
    // Remove the top element from the Stack
    public void pop() {
         if (!stack.isEmpty()) {
            stack.pop();
        }
    }
    // Returns top element of the Stack
    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek()[0];
    }
    // Finds minimum element of Stack
    public int getMin() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek()[1];
    }
}

