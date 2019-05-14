class Solution {
    public int[] dailyTemperatures(int[] arr) {
        
        int n=arr.length;
        int ans[]=new int[n];
        ans[n-1]=0;
        for(int i=0;i<n-1;i++)
        {
            
            for(int k=i+1;k<n;k++)
            {
                if(arr[k]>arr[i])
                {
                    ans[i]=k-i;
                    break;
                }
            }
        }
        
        return ans;
        
    }
}
