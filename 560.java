class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int count=0;
        int n=nums.length;
        int sum=0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                int freq=map.get(sum-k);
                count+=freq;
            }
            
            if(map.containsKey(sum)){
                int freq=map.get(sum);
                freq++;
                map.put(sum,freq);
            }
            else{
                map.put(sum,1);
            }
            
        }
        
        return count;
        
    }
}
