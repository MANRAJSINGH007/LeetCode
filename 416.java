class Solution {
    public int fun(int[] a, int sum1, int i, int[][] dp, int h)
    {
        if(i==a.length){
            
            if(sum1==h){
                return 1;
            }   
            
            return 0;
            
        }
        
        if(dp[i][sum1]!=-1){
            return dp[i][sum1];
            
        }
        
        int x=fun(a,sum1+a[i],i+1,dp,h);
        
        if(x==1){
            return dp[i][sum1]=x;
        }
        
        return dp[i][sum1]=fun(a,sum1,i+1,dp,h);
        
    }
    public boolean canPartition(int[] arr) {
        
        int n=arr.length;
        int sum=0;
        
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        
        if(sum%2!=0){
            return false;
        }
        
        int dp[][]=new int[n][sum+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j]=-1;
            }
        }
        int h=sum/2;
        
        if(fun(arr,0,0,dp,h)==1)
            return true;
        
        return false;
    }
}
