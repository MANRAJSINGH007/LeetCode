class Solution {
    public int maxSubArray(int[] nums) {
        
        int n=nums.length;
        int best=0;
        int current=0;
        int flag=0;
        int min=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>=0)
            {
                flag=1;
                current+=nums[i];
                if(current>best)
                {
                    best=current;
                }
            }
            else
            {
                if(nums[i]>min)
                {
                    min=nums[i];
                }
                current+=nums[i];
                if(current<0)
                {
                    current=0;
                }
                else if(current>best)
                {
                    best=current;
                }
            }
        }
        
        if(flag==0)
        {
            return min;
        }
        
        return best;
        
    }
}
