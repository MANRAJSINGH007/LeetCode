class Solution {
    
    
    public static double function(int[] arr, int n, int i, int k, int[] sum, double[][] dp){
        
        if(i==n){
            return (double)0;
        }
        
        if(k==1){
            
            if(i==0){
                return (double)1.0*sum[n-1]/n;
            }
            
            return (double)1.0*(sum[n-1]-sum[i-1])/(n-i);
        }
        
        if(dp[i][k]!=-1.0*(100000)){
            return dp[i][k];
        }
        
        double max=1.0*(-100000);
        
        for(int j=i;j<n;j++){
            
            int small=sum[j];
            if(i!=0){
                small-=sum[i-1];
            }
            
            double temp=1.0*small/(j-i+1);
            
            temp+=function(arr,n,j+1,k-1,sum,dp);
            
            if(temp>max){
                max=temp;
            }
            
            
        }
        
        return dp[i][k]=max;
        
    }
    
    
    
    public double largestSumOfAverages(int[] arr, int k) {
        
        int n=arr.length;
        int sum[]=new int[n];
        
        int s=0;
        // store the suffix sums in an array named sum.
        for(int i=0;i<n;i++){
            s+=arr[i];
            sum[i]=s;
        }
        
        double dp[][]=new double[n][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=k;j++){
                dp[i][j]=1.0*(-100000);
            }
        }
        
        return function(arr,n,0,k,sum,dp);
        
        
    }
}
