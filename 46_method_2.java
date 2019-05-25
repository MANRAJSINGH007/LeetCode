class Solution {
    
    public static List<List<Integer>> func(int[] arr, int n, int i){
        
        if(i==n){
            List<List<Integer>> ans=new ArrayList<>();
            ans.add(new ArrayList<>());
            return ans;
        }
        
        List<List<Integer>> small=func(arr,n,i+1);
        List<List<Integer>> ans=new ArrayList<>();
        
        for(int k=0;k<small.size();k++){
            
            List<Integer> curr=small.get(k);
            if(curr.size()==0){
                List<Integer> list=new ArrayList<>();
                list.add(arr[i]);
                ans.add(list);
            }
            else{
                for(int p=0;p<=curr.size();p++){
                    List<Integer> temp=new ArrayList<>();
                    for(int j=0;j<curr.size();j++){
                        temp.add(curr.get(j));
                    }
                    temp.add(p,arr[i]);
                    ans.add(temp);
                }
            }
        }
        
        return ans;
        
    }
    
    
    public List<List<Integer>> permute(int[] nums) {
        
        int n=nums.length;
        return func(nums,n,0);
        
    }
}
