class Solution {
    
    public static boolean func(int[] arr, int n, int j, boolean[] visited, int curr_subset, int curr_sum, int val, int k){
        
        if(curr_subset==k){
            for(int i=0;i<n;i++){
                if(!visited[i]){
                    return false;
                }
            }
            
            return true;
        }
        
        if(curr_sum==val){
            return func(arr,n,0,visited,curr_subset+1,0,val,k);
        }
        
        if(j==n){
            return false;
        }
        
        if(!visited[j] && curr_sum+arr[j]<=val){
            visited[j]=true;
            boolean b=func(arr,n,j+1,visited,curr_subset,curr_sum+arr[j],val,k);
            if(b){
                return true;
            }
            
            visited[j]=false;
            
            
        }
        
        return func(arr,n,j+1,visited,curr_subset,curr_sum,val,k);
        
        
    }
    
    public boolean canPartitionKSubsets(int[] arr, int k) {
        
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        
        if(sum%k!=0){
            return false;
        }
        
        int val=sum/k;
        
        boolean visited[]=new boolean[n];
        
        return func(arr,n,0,visited,0,0,sum/k,k);
    }
}
