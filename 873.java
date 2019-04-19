class Solution {
    
    public static int func(int[] arr, int n){
      
      
      HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
      for(int i=0;i<n;i++){
        map.put(arr[i],i);
      }
      
      int max=0;
      
      int dp[][]=new int[n][n];
      for(int i=n-2;i>=0;i--){
        for(int j=i+1;j<n;j++){
          int next=arr[j]+arr[i];
          if(map.get(next)!= null && map.get(next)>j){
            dp[i][j]=dp[j][map.get(next)]+1;
            max=Math.max(max,dp[i][j]+2);
          }
        }
      }
             
         if(max==2){
           return 0;
         }
    
        return max;
    }
  
  
    
    public int lenLongestFibSubseq(int[] arr) {
      
      int max=0;
      int n=arr.length;
      return func(arr,n);
        
    }
}
