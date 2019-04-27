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
    
    static HashMap<Integer,Integer> map=new HashMap<>();
    static int max_count=0;
    static int elements=0;
    
    public static int func(TreeNode root){
        
        if(root==null){
            return 0;
        }
        
        int l=func(root.left);
        int r=func(root.right);
        
        int s=l+r+root.val;
        if(map.containsKey(s)){
            int count=map.get(s);
            count++;
            map.put(s,count);
            if(count==max_count){
                elements++;
            }
            else if(max_count<count){
                elements=1;
                max_count=count;
            }
        }
        else{
            map.put(s,1);
            if(max_count==1){
                elements++;
            }
            else if(max_count==0){
                elements++;
                max_count=1;
            }
        }
        
        return s;
        
    }
    
    
    public int[] findFrequentTreeSum(TreeNode root) {
        
        map=new HashMap<>();
        elements=0;
        max_count=0;
        int k=0;
        int total=func(root);
        int arr[]=new int[elements];
        
        Set<Integer> keys=map.keySet();
        for(Integer i:keys){
            if(map.get(i)==max_count){
                arr[k]=i;
                k++;
            }
        }
        
        return arr;
    }
}
