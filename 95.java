class Solution {
    
    public static List<TreeNode> func(int start, int end, HashMap<String,List<TreeNode>> dp){
        
        if(start>end){
            List<TreeNode> list=new ArrayList<>();
            list.add(null);
            return list;
        }
        
        String temp=Integer.toString(start)+",";
        temp+=Integer.toString(end);
        
        if(dp.containsKey(temp)){
            return dp.get(temp);
        }
        
        List<TreeNode> list=new ArrayList<>();
        
        for(int i=start;i<=end;i++){
            List<TreeNode> l1=func(start,i-1,dp);
            List<TreeNode> l2=func(i+1,end,dp);
            for(int k=0;k<l1.size();k++){
                for(int p=0;p<l2.size();p++){
                    TreeNode root=new TreeNode(i);
                    root.left=l1.get(k);
                    root.right=l2.get(p);
                    list.add(root);
                }
            }
            
        }
        
        dp.put(temp,list);
        return list;
        
    }
    
    
    public List<TreeNode> generateTrees(int n) {
        
        if(n==0){
            return new ArrayList<>();
        }
        
        HashMap<String,List<TreeNode>> dp=new HashMap<>();
        return func(1,n,dp);
        
    }
}
