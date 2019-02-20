class Solution {
    
    public static int func(int[] stones, HashMap<Integer,Integer> map, int i, int prev, int n, int[][] dp)
    {
        if(i==stones[n-1])
        {
            return 1;
        }
        
        if(!map.containsKey(i))
        {
            //no stone at this position.
            return 0;
        }
        
        if(i>stones[n-1])
        {
            return 0;
        }
        
        int index=map.get(i);
        if(dp[index][prev]!=-1)
        {
            return dp[index][prev];
        }
        
        int b1=0;
        int b2=0;
        int b3=0;
        
        if(prev>1)
        {
            b1=func(stones,map,i+prev-1,prev-1,n,dp);
            if(b1==1)
            {
                return dp[index][prev]=1;
            }
        }
        
        b2=func(stones,map,i+prev,prev,n,dp);
        
        if(b2==1)
        {
            return dp[index][prev]=1;
        }
        
        b3=func(stones,map,i+prev+1,prev+1,n,dp);
        if(b3==1)
        {
            return dp[index][prev]=1;
        }
        
        return dp[index][prev]=0;
        
    }
    
    
    public boolean canCross(int[] stones) {
        
        int n=stones.length;
        
        if(stones[1]!=1)
        {
            return false;
        }
        
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        
        for(int i=0;i<n;i++)
        {
            map.put(stones[i],i);
        }
        
        int dp[][]=new int[n][n+1];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                dp[i][j]=-1;
            }
        }
        
        
        if(func(stones,map,1,1,n,dp)==1)
        {
            return true;
        }
        
        return false;
    }
}
