class Solution {
    
    public static int func(int[] nums, int n, int i, int m, int[] extra, int[][] dp){
        
        if(m==1){
            
            if(i==n){
                return Integer.MAX_VALUE;
            }
            
            if(i!=0)
                return extra[n-1]-extra[i-1];
            
            return extra[n-1];
        }
        
        if(i==n){
            return Integer.MAX_VALUE;
        }
        
        if(dp[i][m]!=-1){
            return dp[i][m];
        }
        
        int min=Integer.MAX_VALUE;
        int sum=0;
        
        for(int j=i;j<n;j++){
            
            sum+=nums[j];
            int small_ans=func(nums,n,j+1,m-1,extra,dp);
            int curr_max=Math.max(small_ans,sum);
            min=Math.min(min,curr_max);
            
        }
        
        return dp[i][m]=min;    
    }
    
    public int splitArray(int[] nums, int m) {
        
        int n=nums.length;
        
        if(n==0){
            return 0;
        }
        
        int dp[][]=new int[n][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j]=-1;
            }
        }
        
        int extra[]=new int[n];
        extra[0]=nums[0];
        
        for(int i=1;i<n;i++){
            extra[i]=extra[i-1]+nums[i];
        }
        
        return func(nums,n,0,m,extra,dp);
        
    }
}
