class Solution {
    public int trap(int[] height) {
        
        int n=height.length;
        if(n==0){
            return 0;
        }
        
        int right_max[]=new int[n];
        for(int i=n-2;i>=0;i--){
            right_max[i]=Math.max(right_max[i+1],height[i+1]);
        }
        
        int water=0;
        int left_max=height[0];
        for(int i=1;i<n-1;i++){
            int curr=height[i];
            left_max=Math.max(left_max,height[i-1]);
            if(curr<Math.min(left_max,right_max[i])){
                water+=Math.min(left_max,right_max[i])-curr;
            }
        }
        
        return water;
        
    }
}
