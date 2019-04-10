class Solution {
    
    public static int func(String s, String p, int n, int m, int i, int j, int[][] dp)
    {
        if(i==n)
        {
            while(j!=m)
            {
                if(p.charAt(j)!='*')
                {
                    return 0;
                }
                j++;
            }
            
            return 1;
        }
        if(j==m)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        char ch=p.charAt(j);
        if(ch!='*' && ch!='?' && ch!=s.charAt(i))
        {
            return dp[i][j]=0;
        }
        else if(ch==s.charAt(i))
        {
            return dp[i][j]=func(s,p,n,m,i+1,j+1,dp);
        }
        
        if(ch=='?')
        {
            return dp[i][j]=func(s,p,n,m,i+1,j+1,dp);
        }
        
        if(ch=='*')
        {
            int c=0;
            while(c<=n-i)
            {
              int val=func(s,p,n,m,i+c,j+1,dp);
              if(val==1)
              {
                return dp[i][j]=1;
              }
                c++;
            }
        }
        
        return dp[i][j]=0;
        
        
    }
    
    
    public boolean isMatch(String s, String p) {
        
        int n=s.length();
        int m=p.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dp[i][j]=-1;
            }
        }
        if(func(s,p,n,m,0,0,dp)==1)
        {
            return true;
        }
        
        return false;
    }
}
