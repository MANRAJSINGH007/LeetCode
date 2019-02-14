class Solution {
    public int[] countBits(int n) {
        
        int dp[]=new int[n+1];
        int curr=1;
        while(curr<=n){
            
            dp[curr]=1;
            curr*=2;
            
        }
        
        for(int i=3;i<=n;i++)
        {
            int closest=(int)(Math.log(i)/Math.log(2));
            int prev=(int)Math.pow(2,closest);
            dp[i]=dp[prev]+dp[i-prev];
            
        }
        
        return dp;
        
        
        
    }
}
