class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
		if(k == 1) return true;
        if(n % k != 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            int count = 1;
            if(map.containsKey(nums[i])) count += map.get(nums[i]);
            if(!map.containsKey(nums[i])) list.add(nums[i]);
            map.put(nums[i], count);
        }
        
        Collections.sort(list);
        
        for(int i = 0; i < list.size();){
            int curr = list.get(i);
            int currLength = 0;
            while(currLength < k && map.containsKey(curr) && map.get(curr) > 0){
                int c = map.get(curr);
                currLength++;
                c--;
                map.put(curr, c);
                curr++;
            }
            if(currLength < k) return false;
            while(i < list.size() && map.get(list.get(i)) == 0) i++;
        }
        return true;
    }
}
