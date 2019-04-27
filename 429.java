/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        if(root==null){
            return new ArrayList<List<Integer>>();
        }
        
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        q.add(null);
        
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        
        while(q.size()!=1){
            
            Node p=q.remove();
            if(p==null){
                list.add(curr);
                curr=new ArrayList<Integer>();
                q.add(null);
                continue;
            }
            
            curr.add(p.val);
            
            List<Node> children=p.children;
            for(int i=0;i<children.size();i++){
                Node t=children.get(i);
                if(t!=null){
                    q.add(t);
                }
            }
            
        }
        
        list.add(curr);
        return list;
        
    }
}
