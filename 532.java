class Solution {
    public int findPairs(int[] nums, int k) {
        
        int n = nums.length;
        if(n == 0 || k < 0) return 0;
        
        if(k == 0){
            
            int count = 0;
            
            HashMap<Integer, Integer> map = new HashMap<>();
            
            for(int i = 0; i < n; i++){
                if(!map.containsKey(nums[i])) map.put(nums[i], 1);
                else{
                    int c = 0;
                    c = map.get(nums[i]);
                    if(c == 1) count ++;
                    map.put(nums[i], 2);
                }
            }
            
            return count;
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        int count = 0;
        
        for(int i = 0; i < n; i++){
            
            if(!set.contains(nums[i])){
                if(set.contains(nums[i] - k)) count++;
                if(set.contains(nums[i] + k)) count++;
                set.add(nums[i]);
            }
        }
        
        return count;
    }
}
