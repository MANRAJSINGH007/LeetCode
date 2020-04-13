class Solution {
    
    public static int func(int[] arr, int n, int i, int k, int[] dp){
        
        if(i==n) return 0;
        
        if(dp[i]!=-1) return dp[i];
        
        int ans=0;
        int max=arr[i];
        for(int j=i;j<Math.min(n,i+k);j++){
            int curr_length=j-i+1;
            max=Math.max(arr[j],max);
            ans=Math.max(max*curr_length+func(arr,n,j+1,k,dp),ans);
        }
        
        return dp[i]=ans;
        
    }
    
    public int maxSumAfterPartitioning(int[] A, int K) {
        
        int n=A.length;
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        return func(A,A.length,0,K,dp);
        
    }
}
