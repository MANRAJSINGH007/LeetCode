class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        int n = nums.length;
        
        if(n == 0){
            return new ArrayList<>();
        }
        
        int prev = nums[0];
        
        List<String> ans = new ArrayList<>();
        if(n == 1){
            ans.add(Integer.toString(prev));
            return ans;
        }

        for(int j = 1; j < n; j++){
            if(nums[j] == nums[j - 1] + 1){
                if(j == n - 1){
                    String temp = "" + Integer.toString(prev);
                    temp += "->" + Integer.toString(nums[n - 1]);
                    ans.add(temp);
                    return ans;
                }
            }
            else{
                String temp = "" + Integer.toString(prev);
                if(prev != nums[j - 1]) temp += "->" + Integer.toString(nums[j - 1]);
                ans.add(temp);
                prev = nums[j]; 
                if(j == n - 1){
                    ans.add(Integer.toString(prev));
                    return ans;
                }
            }
        }
        
        return ans;
        
    }
}
