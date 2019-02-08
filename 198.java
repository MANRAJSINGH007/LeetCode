class Solution {
    public int rob(int[] nums) {
        
        
        int n=nums.length;
        if(n==0)
        {
            return 0;
        }
        int m1=nums[0];
        if(n==1)
        {
            return m1;
        }
        int m2=m1;
        if(nums[1]>nums[0])
        {
            m2=nums[1];
        }
        
        for(int i=2;i<n;i++)
        {
            int temp=m1+nums[i];
            if(temp>m2)
            {
                m1=m2;
                m2=temp;
            }
            else
            {
                m1=m2;
            }
        }
        return m2;
        
    }
}
