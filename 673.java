class Pair{
    int l;
    int f;
    Pair(int l, int f){
        this.l = l;
        this.f = f;
    }
}

class Solution {
    
    public static Pair func(int[] nums, int n, int i, Pair[] dp){
        
        if(i == n) return new Pair(0, 1);
        
        if(dp[i] != null) return dp[i];
        
        Pair ans = new Pair(1, 1);
        Pair max = new Pair(0, 1);
        
        for(int j = i + 1; j < n; j++){
            if(nums[j] > nums[i]){
                Pair small = func(nums, n, j, dp);
                if(small.l > max.l){
                    max.l = small.l;
                    max.f = small.f;
                } else if(small.l != 0 && small.l == max.l) max.f += small.f;
            }
        }
        
        if(max.l != 0){
            ans.l += max.l;
            ans.f = max.f;
        }
        
        return dp[i] = ans;
        
    }
    
    
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length;
        if(n == 0) return 0;
        Pair[] dp = new Pair[n];
        int max = 1, freq = n;
        for(int i = 0; i < n; i++){
            Pair ans = func(nums, n, i, dp);
            if(ans.l > 1 && ans.l == max)freq += ans.f;
            else if(ans.l > max){
                max = ans.l;
                freq = ans.f;
            }
        }
        
        return freq;
        
        
    }
}
