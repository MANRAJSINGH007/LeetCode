class Solution {
    
    public static int func(String s, int i, int n, int[] dp){
        
        if(i==n){
            return 1;
        }
        
        if(dp[i]!=-1){
            return dp[i];
        }
        
        char curr=s.charAt(i);
        int m1=0;
        int m2=0;
        
        if(i!=n-1){
            int temp=Integer.parseInt(""+curr+s.charAt(i+1));
            if(temp>=10 && temp<=26){
                m1+=func(s,i+2,n,dp);
            }
        }
        
        if(curr!='0')
            m2=func(s,i+1,n,dp);
        return dp[i]=m1+m2;
        
    }
    
    public int numDecodings(String s) {
        
        int n=s.length();
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        return func(s,0,n,dp);
        
    }
}
