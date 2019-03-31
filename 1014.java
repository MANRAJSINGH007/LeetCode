class Solution {
    public int maxScoreSightseeingPair(int[] arr) {
        
        int n=arr.length;
        
        int left_max[]=new int[n];
        int right_max[]=new int[n];
        
        left_max[0]=arr[0];
        for(int i=1;i<n;i++){
            left_max[i]=Math.max(left_max[i-1],arr[i]+i);
        }
        
        right_max[n-1]=arr[n-1]-n+1;
        for(int i=n-2;i>=0;i--){
            right_max[i]=Math.max(right_max[i+1],arr[i]-i);
        }
        
        int max=0;
        for(int i=0;i<n-1;i++){
            int left=left_max[i];
            int right=right_max[i+1];
            max=Math.max(left+right,max);
        }
        
        return max;
        
    }
}
