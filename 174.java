class Solution {
    public int calculateMinimumHP(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int dp[][]=new int[n][m];
		    for(int i=0;i<n;i++)
		    {
		        for(int k=0;k<m;k++)
		        {
		           
		            dp[i][k]=0;
		        }
		    }
		    
		  //  System.out.println(func(arr,n,m,0,0,dp));
		  if(arr[n-1][m-1]>0)
		  {
		      dp[n-1][m-1]=0;
		  }
		  else
		  {
		      int temp=-arr[n-1][m-1];
		      temp++;
		      dp[n-1][m-1]=temp;
		  }
		  for(int i=m-2;i>=0;i--)
		  {
		      if(arr[n-1][i]<=0)
		      {
		          if(dp[n-1][i+1]>0)
		          {
		              dp[n-1][i]=dp[n-1][i+1]-arr[n-1][i];
		          }
		          else
		          {
		              dp[n-1][i]=-arr[n-1][i]+1;
		          }
		      }
		      else
		      {
		          if(arr[n-1][i]>dp[n-1][i+1])
		          {
		              dp[n-1][i]=0;
		          }
		          else
		          {
		              dp[n-1][i]=dp[n-1][i+1]-arr[n-1][i];
		          }
		      }
		  }
		  for(int i=n-2;i>=0;i--)
		  {
		      if(arr[i][m-1]<=0)
		      {
		          if(dp[i+1][m-1]>0)
		          {
		              dp[i][m-1]=dp[i+1][m-1]-arr[i][m-1];
		          }
		          else
		          {
		              dp[i][m-1]=-arr[i][m-1]+1;
		          }
		      }
		      else
		      {
		          if(arr[i][m-1]>dp[i+1][m-1])
		          {
		              dp[i][m-1]=0;
		          }
		          else
		          {
		              dp[i][m-1]=dp[i+1][m-1]-arr[i][m-1];
		          }
		      }
		  }
		  
		  for(int i=n-2;i>=0;i--)
		  {
		      for(int k=m-2;k>=0;k--)
		      {
		          int smaller=Math.min(dp[i+1][k],dp[i][k+1]);
		          if(arr[i][k]<=0)
    		      {
    		          if(smaller>0)
    		          {
    		              dp[i][k]=smaller-arr[i][k];
    		          }
    		          else
    		          {
    		              dp[i][k]=-arr[i][k]+1;
    		          }
    		      }
    		      else
    		      {
    		          if(arr[i][k]>smaller)
    		          {
    		              dp[i][k]=0;
    		          }
    		          else
    		          {
    		              dp[i][k]=smaller-arr[i][k];
    		          }
    		      }
		      }
		  }
		  if(dp[0][0]==0)
		  {
		      dp[0][0]=1;
		  }
        
        return dp[0][0];
        
    }
}
