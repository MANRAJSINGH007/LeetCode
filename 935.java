class Solution {
    
    public static int func(int i, int j, int keys, int[][][] dp)
    {
        
        if(i<0 || i>3 || j<0 || j>2)
        {
            return 0;
        }
        
        if(i==3 && (j==0 || j==2))
        {
            return 0;
        }
        
        if(keys==0)
        {
            return 1;
        }
        
        if(dp[i][j][keys]!=-1){
            return dp[i][j][keys];
        }
        
        int m1=func(i+1,j+2,keys-1,dp);
        int m2=func(i+1,j-2,keys-1,dp);
        int m3=func(i+2,j+1,keys-1,dp);
        int m4=func(i+2,j-1,keys-1,dp);
        int m5=func(i-1,j+2,keys-1,dp);
        int m6=func(i-1,j-2,keys-1,dp);
        int m7=func(i-2,j-1,keys-1,dp);
        int m8=func(i-2,j+1,keys-1,dp);
        
       long temp=(long)0+m1+m2+m3+m4+m5+m6+m7+m8;
        
       return dp[i][j][keys]=(int)(temp%1000000007);
        
    }
    
    
    public int knightDialer(int keys) {
        
        int dp[][][]=new int[4][3][keys];
        
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<keys;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        
        int m1=func(0,0,keys-1,dp);
        int m2=func(1,0,keys-1,dp);
        int m3=func(2,0,keys-1,dp);
        int m4=func(0,1,keys-1,dp);
        int m5=func(1,1,keys-1,dp);
        int m6=func(2,1,keys-1,dp);
        int m7=func(0,2,keys-1,dp);
        int m8=func(1,2,keys-1,dp);
        int m9=func(2,2,keys-1,dp);
        int m0=func(3,1,keys-1,dp);
        
        long temp=(long)0+m1+m2+m3+m4+m5+m6+m7+m8+m9+m0;
        
        return (int)(temp%1000000007);
    }
}
