class Solution {
    
    static List<List<Integer>> ans = new ArrayList<>();
    
    public static void func(List<Integer> nums, int n, HashMap<Integer, Integer> map, List<Integer> list, int total){
        
        if(total == 0){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < list.size(); j++){
                temp.add(list.get(j));
            }
            ans.add(temp);
            return ;
        }
        
        for(int k = 0; k < n; k++){
            if(map.get(nums.get(k)) > 0){
                int count = map.get(nums.get(k));
                count--;
                map.put(nums.get(k), count);
                list.add(nums.get(k));
                func(nums, n, map, list, total - 1);
                list.remove(list.size() - 1);
                count++;
                map.put(nums.get(k), count);
            }
        }
        
        return ;
        
        
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            int curr = nums[i];
            int count = 0;
            if(map.containsKey(curr)) count = map.get(curr);
            count++;
            map.put(curr, count);
        }
        
        List<Integer> arr = new ArrayList<>();
        Set<Integer> keys = map.keySet();
        for(Integer k : keys){
            arr.add(k);
        }
        
        int total = n;
        
        Collections.sort(arr);
        
        n = arr.size();
        
        ans = new ArrayList<>();
        func(arr, n, map, new ArrayList<>(), total);
        return ans;
        
    }
}
