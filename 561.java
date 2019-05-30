class Solution {
    public int arrayPairSum(int[] nums) {
        
        int m=nums.length;
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<m;i+=2){
            sum+=nums[i];
        }
        
        return sum;
    }
}
