class Solution {
    
    public static boolean check(int[][] dp, int left, int right, int k){
        
        int n=right-left+1;
        
        if(n==1){
            return true;
        }
        
        int count=0;
        
        for(int i=0;i<26;i++){
            int curr_val=dp[right][i];
            if(left!=0){
                curr_val-=dp[left-1][i];
            }
            
            if(curr_val%2==1){
                count++;
            }
        }
        
       
        if(count/2<=k){
            return true;
        }

        return false;
        
    }
    
    public static void preprocess(String s, int n, int[][] dp){
        
        for(int i=0;i<n;i++){
            char curr=s.charAt(i);
            int index=(int)curr-97;
            if(i==0){
                dp[i][index]=1;
            }
            else{
                dp[i][index]=dp[i-1][index]+1;
                for(int k=0;k<26;k++){
                    if(k!=index){
                        dp[i][k]=dp[i-1][k];
                    }
                }
            }
        }
        
        return ;
        
    }
    
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        
        int n=s.length();
        int dp[][]=new int[n][26];
        preprocess(s,n,dp);
        
        List<Boolean> list=new ArrayList<>();
        
        for(int i=0;i<queries.length;i++){
            
            int left=queries[i][0];
            int right=queries[i][1];
            int k=queries[i][2];
            
            if(right-left+1<k){
                list.add(false);
            }else{
                list.add(check(dp,left,right,k));
            }
        }
        
        return list;
        
    }
}
