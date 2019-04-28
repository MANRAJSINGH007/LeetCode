class Solution {
    
    public static int func(int[] arr, int[] brr, int n, int m, int i, int j, int[][] dp){
        
        if(i==n || j==m){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int num=arr[i];
        int max=0;
        for(int k=j;k<m;k++){
            if(brr[k]==num){
                max=1+func(arr,brr,n,m,i+1,k+1,dp);
                break;
            }
        }
        
        max=Math.max(max,func(arr,brr,n,m,i+1,j,dp));
        return dp[i][j]=max;
        
    }
    
    public int maxUncrossedLines(int[] arr, int[] brr) {
        
        int n=arr.length;
        int m=brr.length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return func(arr,brr,n,m,0,0,dp);
        
    }
}
