class Solution {
    
    public static int func(int[] d, int[] costs, int curr, int[] dp){
        
        if(curr>365){
            return 0;
        }
        
        if(dp[curr]!=-1){
            return dp[curr];
        }
        
        int j=curr;
        while(j<366 && d[j]==0){
            j++;
        }
        
        if(j>365){
            return dp[curr]=0;
        }
        
        int m1=costs[0]+func(d,costs,j+1,dp);
        int m2=costs[1]+func(d,costs,j+7,dp);
        int m3=costs[2]+func(d,costs,j+30,dp);
        
        return dp[curr]=Math.min(m1,Math.min(m2,m3));
        
        
    }
    
    
    public int mincostTickets(int[] days, int[] costs) {
        
        int n=days.length;
        
        int d[]=new int[366];
        for(int i=0;i<n;i++){
            d[days[i]]=1;
        }
        
        int dp[]=new int[366];
        for(int i=1;i<366;i++){
            dp[i]=-1;
        }
        return func(d,costs,1,dp);
        
        
    }
}
