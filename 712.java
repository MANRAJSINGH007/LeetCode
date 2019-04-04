class Solution {
    
    public static int func(String s1, String s2, int n, int m, int i, int j, int[][] dp)
    {
        if(i==n)
        {
           int sum=0;
           for(int p=j;p<m;p++)
           {
               sum+=(int)s2.charAt(p);
           }
            
            return sum;
        }
        if(j==m)
        {
           int sum=0;
           for(int p=i;p<n;p++)
           {
               sum+=(int)s1.charAt(p);
           }
            
            return sum;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(s1.equals(s2))
        {
            return 0;
        }
        if(s1.charAt(i)==s2.charAt(j))
        {
            int cost=func(s1,s2,n,m,i+1,j+1,dp);
            return dp[i][j]=cost;
        }
        else
        {
            int cost1=(int)s1.charAt(i)+func(s1,s2,n,m,i+1,j,dp);
            int cost2=(int)s2.charAt(j)+func(s1,s2,n,m,i,j+1,dp);
            if(cost1<=cost2)
            {
                return dp[i][j]=cost1;
            }
            
            return dp[i][j]=cost2;
        }
    }
    
    
    public int minimumDeleteSum(String s1, String s2) {
        
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dp[i][j]=-1;
            }
        }
        return func(s1,s2,n,m,0,0,dp);
        
    }
}
