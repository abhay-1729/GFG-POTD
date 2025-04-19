//Problem: Maximum XOR of two numbers in an array(GFG)
class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    private void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    private int findMaxXor(int num) {
        TrieNode node = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int oppositeBit = 1 - bit;
            if (node.children[oppositeBit] != null) {
                maxXor |= (1 << i);
                node = node.children[oppositeBit];
            } else {
                node = node.children[bit];
            }
        }
        return maxXor;
    }

    public int maxXor(int[] arr) {
        int maxResult = 0;
        insert(arr[0]); // Insert the first number

        for (int i = 1; i < arr.length; i++) {
            int currXor = findMaxXor(arr[i]);
            maxResult = Math.max(maxResult, currXor);
            insert(arr[i]); // Then insert into Trie
        }
        return maxResult;
    }
}
