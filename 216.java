class Solution {
    
    static List<List<Integer>> ans=new ArrayList<>();
    
    public static void function(int n, int k, int i, List<Integer> curr){
        
        if(k==0 && n==0){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<curr.size();j++){
                temp.add(curr.get(j));
            }
            
            ans.add(temp);
            
            return ;
        }
        
        if(n==0 || k==0 || i==10){
            return ;
        }
        
        curr.add(i);
        function(n-i,k-1,i+1,curr);
        curr.remove(curr.size()-1);
        function(n,k,i+1,curr);
        
        return ;
        
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        ans=new ArrayList<>();
        
        function(n,k,1,new ArrayList<>());
        
        return ans;
        
    }
}
