//Problem: Clone an Undirected Graph

private Map<Node, Node> visited = new HashMap<>();

    Node cloneGraph(Node node) {
        if (node == null) return null;

        // If the node is already cloned, return it
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Clone the node
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        // Clone all the neighbors recursively
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
