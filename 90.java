class Solution {
    
    static List<List<Integer>> ans=new ArrayList<>();
    
    public static void func(List<Integer> arr, int n, int i, List<Integer> list, HashMap<Integer,Integer> map){
        
        if(i==n){
            List<Integer> temp=new ArrayList<>();
            for(int k=0;k<list.size();k++){
                temp.add(list.get(k));
            }
            ans.add(temp);
            return ;
        }
        
        int count=0;
        int freq=map.get(arr.get(i));
        
        while(count<=freq){
            
            func(arr,n,i+1,list,map);
            count++;
            list.add(arr.get(i));
        }
        
        while(count!=0){
            count--;
            list.remove(list.size()-1);
        }
        
        return ;
        
        
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        ans=new ArrayList<>();
        
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                int count=map.get(nums[i]);
                count++;
                map.put(nums[i],count);
            }
            else{
                map.put(nums[i],1);
            }
        }
        
        Set<Integer> keys=map.keySet();
        List<Integer> arr=new ArrayList<>();
        
        for(Integer k:keys){
            arr.add(k);
        }
        
        n=arr.size();
        
        func(arr,n,0,new ArrayList<>(),map);
        return ans;
        
    }
}
