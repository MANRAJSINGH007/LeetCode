class Solution {
    
    public static boolean check(String s, int start, int end){
        
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
        
    }
    
    public static int func(String s, int start, int end, int[][] dp){
        
        if(start>end){
            return Integer.MAX_VALUE;
        }
        
        if(dp[start][end]!=-1){
            return dp[start][end];
        }
        
        if(check(s,start,end)){
            return dp[start][end]=1;
        }
        
        int min=end-start+1;
        
        for(int i=start+1;i<=end;i++){
            int ans1=func(s,start,i-1,dp);
            int ans2=func(s,i,end,dp);
            
            if(ans1!=Integer.MAX_VALUE && ans2!=Integer.MAX_VALUE && ans1+ans2<min){
                min=ans1+ans2;
            }
        }
        
        return dp[start][end]=min;
        
        
    }
    
    public int minCut(String s) {
        
        int dp[][]=new int[s.length()][s.length()];
        
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                dp[i][j]=-1;
            }
        }
        
        return func(s,0,s.length()-1,dp)-1;
    }
}
