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
    
    static List<Integer> list=new ArrayList<>();
    
    public static void func(Node root){
        
        if(root==null){
            return ;
        }
        
        List<Node> children=root.children;
        for(int i=0;i<children.size();i++){
            func(children.get(i));
        }
        
        list.add(root.val);
        
        return ;
        
    }
    
    public List<Integer> postorder(Node root) {
        
        list.clear();
        func(root);
        return list;
        
    }
}
