/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    
    public Node dfsUtil(Node node, Map<Node, Node> visited) {

        Node cloned = new Node(node.val, new ArrayList<>());
        visited.put(node, cloned);

        for (Node neighbour : node.neighbors) {
            Node clonedNeighbour = visited.containsKey(neighbour) ? visited.get(neighbour) : dfsUtil(neighbour, visited);
            cloned.neighbors.add(clonedNeighbour);
        }

        return cloned;
    }

    
    public Node cloneGraph(Node node) {
        
        if(node == null) return node;
        
        return dfsUtil(node, new HashMap<>());
        
    }
}
