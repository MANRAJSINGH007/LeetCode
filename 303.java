class NumArray {
    
    private int nums[];
    public int sum[];
    public int length;
    public NumArray(int[] nums) {
        
        this.nums=nums;
        int n=this.nums.length;
        sum=new int[n];
        int s=0;
        for(int i=0;i<n;i++)
        {
            s+=nums[i];
            sum[i]=s;
        }
        length=n;
    }
    
    public int sumRange(int p, int j) {
        
        // int n=this.sum.length;
        
        if(p<0)
        {
            p=0;
        }
        if(j>=length)
        {
            j=length-1;
        }
        
        if(p==0)
        {
            return sum[j];
        }
        
        return sum[j]-sum[p-1];
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
