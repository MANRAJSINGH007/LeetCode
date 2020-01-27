class Solution {
    
    static HashSet<List<Integer>> ans;
    public static void func(int[] nums, int n, int i, int j, List<Integer> list){
        
        if(i == n){
            if(list.size() < 2) return ;
            ans.add(new ArrayList(list));
            return ;
        }
        
        if(j == -1){
            func(nums, n, i + 1, j, list);
            list.add(nums[i]);
            func(nums, n, i + 1, i, list);
            list.remove(list.size() - 1);
            return ;
        }
        
        func(nums, n, i + 1, j, list);
        
        if(nums[i] >= nums[j]){
            list.add(nums[i]);
            func(nums, n, i + 1, i, list);
            list.remove(list.size() - 1);
        }
        
        return ;
        
    }
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        ans = new HashSet<>();
        int n = nums.length;
        if(n == 0) return new ArrayList<>();
        func(nums, n, 0, -1, new ArrayList<>());
        
        List<List<Integer>> l = new ArrayList(ans);
        return l;
    }
}
