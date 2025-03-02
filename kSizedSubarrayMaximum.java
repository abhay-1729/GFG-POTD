
// Problem: K sized subarray Maximum
// GFG

class Solution {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        // code here
        ArrayList<Integer> result=new ArrayList<Integer>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }

        return result;
    }
}
