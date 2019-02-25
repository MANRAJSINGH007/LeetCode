class Solution {
    
    public int countNumbersWithUniqueDigits(int n) {
        
        if(n>=10){
            return 0;
        }
        
        if(n==0){
            return 1;
        }
        
        if(n==1){
            return 10;
        }
        
        int dp[]=new int[n+1];
        
        dp[0]=10;
        dp[1]=81;
        int mul=8;
        int s=dp[0]+dp[1];
        
        for(int i=2;i<n;i++){
            dp[i]=dp[i-1]*mul;
            s+=dp[i];
            mul--;
            
        }
        
        return s;
        
        
    }
}
