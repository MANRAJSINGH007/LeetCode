class Solution {
    
    static List<List<Integer>> ans=new ArrayList<>();
    
    public static void func(int[] arr, int n, int i, List<Integer> list){
        
        if(i==n){
            List<Integer> temp=new ArrayList<>();
            for(int k=0;k<list.size();k++){
                temp.add(list.get(k));
            }
            ans.add(temp);
            return ;
        }
        
        func(arr,n,i+1,list);
        list.add(arr[i]);
        func(arr,n,i+1,list);
        list.remove(list.size()-1);
        
        return ;
        
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        
        ans=new ArrayList<>();
        int n=nums.length;
        func(nums,n,0,new ArrayList<>());
        return ans;
    }
}
