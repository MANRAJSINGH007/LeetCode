class Solution {
    
    public int fun(int[] num,int S,int i)
    {
        if(i==num.length && S==0)
            return 1;   
        if(i==num.length)
            return 0;
        
        int ans=fun(num,S+num[i],i+1)+fun(num,S-num[i],i+1);
        return ans;
    }
    public int findTargetSumWays(int[] nums, int S) {
        return fun(nums,S,0);
        
    }
}
