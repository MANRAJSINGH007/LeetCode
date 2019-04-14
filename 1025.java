class Solution {
    
    public static boolean func(int n, boolean[] prime, int[] dp){
        
        
        
        if(n==2){
            return true;
        }
        
        if(n==1){
            return false;
        }
        
        if(prime[n]){
            return false;
        }
        
        if(dp[n]!=-1){
            if(dp[n]==0){
                return false;
            }
            
            return true;
        }
        
        for(int i=1;i<=(int)Math.sqrt(n);i++){
            if(i!=n && (n%i)==0){
                if(!func(n-i,prime,dp)){
                    dp[n]=1;
                    return true;
                }
            }
        }
        
        dp[n]=0;
        return false;
        
        
    }
    
    
    public boolean divisorGame(int n) {
        
        if(n==1){
            return false;
        }
        int dp[]=new int[n+1];
        boolean prime[]=new boolean[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }
        
        prime[2]=true;
        for(int i=3;i<=n;i++){
            for(int j=2;j<=(int)Math.sqrt(i);j++){
                prime[i]=true;
                if(i%j==0){
                    prime[i]=false;
                    break;
                }
            }
        }
        
        
        return func(n,prime,dp);
        
    }
}
