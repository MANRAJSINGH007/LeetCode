import java.util.Arrays;
class Solution {
    public int largestPerimeter(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        int ans=0;
        for(int i=n-1;i>=2;i--)
        {
            if(arr[i-1]+arr[i-2]>arr[i])
            {
                ans+=arr[i]+arr[i-1]+arr[i-2];
                break;
            }
        }
        
        return ans;
        
    }
}
