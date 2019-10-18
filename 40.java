class Solution {
    
    static List<List<Integer>> ans=new ArrayList<>();
    
    public static void func(List<Integer> arr, int n, int i, HashMap<Integer,Integer> map, List<Integer> list, int sum){
        
        if(sum<0){
            return ;
        }
        
        if(sum==0){
            
            List<Integer> cur=new ArrayList<>();
            for(int k=0;k<list.size();k++){
                cur.add(list.get(k));
            }
            
            ans.add(cur);
            return ;
        }
        
        if(i==n){
            return ;
        }
        
        int count=0;
        int curr=arr.get(i);
        int freq=map.get(curr);
        
        while(count<=freq){
            func(arr,n,i+1,map,list,sum-count*curr);
            list.add(curr);
            count++;
        }
        
        while(count>0){
            list.remove(list.size()-1);
            count--;
        }
        
        return ;
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        ans=new ArrayList<>();
        int n=candidates.length;
        
        if(n==0){
            return ans;
        }
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            int curr=candidates[i];
            if(map.containsKey(curr)){
                int count=map.get(curr);
                count++;
                map.put(curr,count);
            }
            else{
                map.put(curr,1);
            }
        }
        
        Set<Integer> keys=map.keySet();
        List<Integer> arr=new ArrayList<>();
        
        for(Integer k:keys){
            arr.add(k);
        }
        
        n=arr.size();
        
        func(arr,n,0,map,new ArrayList<>(),target);
        return ans;
        
    }
}
