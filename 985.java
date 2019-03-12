class Solution {
    public int[] sumEvenAfterQueries(int[] arr, int[][] queries) {
        
        int n=arr.length;
        
        int m=queries.length;
        int ans[]=new int[m];
        
        for(int i=0;i<m;i++)
        {
            int val=queries[i][0];    
            int index=queries[i][1];
            arr[index]+=val;
            int sum=0;
            
            for(int k=0;k<n;k++)
            {
                if(arr[k]%2==0)
                    sum+=arr[k];
            }
            ans[i]=sum;
        }
        
        
        return ans;
        
    }
}
