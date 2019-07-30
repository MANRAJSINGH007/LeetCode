class Utility{
    
    int sum;
    int max;
    
    Utility(int sum, int max){
        this.sum=sum;
        this.max=max;
    }
    
}
class Solution {
    
    public static Utility func(int[] arr, int n, int start, int end, Utility[][] dp){
        
        if(start==end){
            return new Utility(0,arr[start]);
        }
        
        if(dp[start][end]!=null){
            return dp[start][end];
        }
        
        int min=Integer.MAX_VALUE;
        
        Utility curr=new Utility(min,0);
        for(int i=start;i<end;i++){
            Utility ans1=func(arr,n,start,i,dp);
            Utility ans2=func(arr,n,i+1,end,dp);
            if(ans1.sum+ans2.sum+ans1.max*ans2.max<curr.sum){
                curr.sum=ans1.sum+ans2.sum+ans1.max*ans2.max;
                curr.max=Math.max(ans1.max,ans2.max);
            }
        }
        
        
        return dp[start][end]=curr;
    }
    
    
    public int mctFromLeafValues(int[] arr) {
        
        int n=arr.length;
        
        Utility[][] dp=new Utility[n][n];
        
        return func(arr,n,0,n-1,dp).sum;
        
    }
}
