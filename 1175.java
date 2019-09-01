class Solution {
    
    static int mod=(int)Math.pow(10,9)+7;
    
    public static long func(int count){
        
        long ans=1;
        
        for(int i=1;i<=count;i++){
            ans=(ans*i)%mod;
        }
        
        return ans;
        
    }
    
    public static int permute(int n){
    
        if(n<=2){
            return n-1;
        }
        
        int count=1;
        
        for(int i=3;i<=n;i++){
            
            int flag=0;
            
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    flag=1;
                    break;
                }
            }
            
            if(flag==0){
                count++;
                
            }
            
        }
        
        return count;
        
    }
    
    public int numPrimeArrangements(int n) {
        
        int count=permute(n);
        long curr=func(count);
        long temp=func(n-count);
        
        long ans=(curr%mod * temp%mod)%mod;
        
        return (int)ans;
        
    }
}
