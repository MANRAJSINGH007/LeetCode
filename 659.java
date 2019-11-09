class Solution {
    public boolean isPossible(int[] nums) {
        
        int n = nums.length;
        if(n <= 2) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            int count = 0;
            if(map.containsKey(nums[i])) count = map.get(nums[i]);
            if(!map.containsKey(nums[i])) list.add(nums[i]);
            map.put(nums[i], ++ count);
        }
        
        for(int i = 0; i < list.size();){
            int curr = list.get(i);
            int currLength = 0;
            while(map.containsKey(curr) && map.get(curr) > 0){
                int c = map.get(curr);
                currLength ++;
                System.out.print(curr + " ");
                c --;
                map.put(curr, c);
                if(map.containsKey(curr + 1) && map.get(curr + 1) > map.get(curr)) curr ++;
                else break;
            }
            
            if(currLength <= 2) return false;
            
            while(i < list.size() && map.get(list.get(i)) == 0) i ++;
        }
        
        return true;
        
    }
}
