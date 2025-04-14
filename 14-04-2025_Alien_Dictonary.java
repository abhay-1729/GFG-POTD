//Problem: Alien Dictionary(GFG)
class Solution {
    public String findOrder(String[] words) {
        // code here
        // Step 1: Initialize graph
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // Initialize nodes
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // Step 2: Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            // Check invalid case: prefix issue
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";

            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        // Step 3: Topological Sort using Kahn's Algorithm
        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) queue.add(c);
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            result.append(curr);
            for (char neighbor : graph.get(curr)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If result doesn't contain all characters → cycle detected
        return result.length() == inDegree.size() ? result.toString() : "";
    }
}
