class Solution {
    
    public boolean checkSubarraySum(int[] nums, int k) {
        
        int n = nums.length;
        if(n == 0) return false;
        
        if(k == 1) return n >= 2;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int currSum = 0;
        
        map.put(0, -1);
        
        if(k == 0){
            
            int currLength = 0;
            
            for(int i = 0; i < n; i++){
                if(nums[i] == 0) currLength++;
                else currLength = 0;
                if(currLength > 1) return true;
            }
            
            return false;
            
        }
        
        for(int i = 0; i < n; i++){
            currSum += nums[i];
            int currMod = currSum % k;
            if(currMod == 0){
                if(map.containsKey(currMod) && i - map.get(currMod) >= 2) return true;
                else if(!map.containsKey(currMod)) map.put(currMod, i);
            }
            else{
                if(map.containsKey(currMod) && i - map.get(currMod) >= 2) return true;
                else if(!map.containsKey(currMod)) map.put(currMod, i);
            }
        }
        
        return false;
        
    }
}
