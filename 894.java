/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    static HashMap<Integer,List<TreeNode>> map=new HashMap<>();
    
    public static List<TreeNode> func(int n){
        
        if(n==0){
            return null;
        }
        
        if(n==1){
            List<TreeNode> list=new ArrayList<>();
            list.add(new TreeNode(0));
            return list;
        }
        
        if(map.containsKey(n)){
            return map.get(n);
        }
        
        List<TreeNode> list=new ArrayList<>();
        
        for(int i=1;i<=n-2;i++){
            
            List<TreeNode> l_list=func(i);
            List<TreeNode> r_list=func(n-1-i);
            for(int t=0;t<l_list.size();t++){
                for(int y=0;y<r_list.size();y++){
                    TreeNode root=new TreeNode(0);
                    root.left=l_list.get(t);
                    root.right=r_list.get(y);
                    list.add(root);
                }
            }
        }
        
        map.put(n,list);
        return list;
        
    }
    
    public List<TreeNode> allPossibleFBT(int N) {
        
        map=new HashMap<>();
        return func(N);
        
    }
}
