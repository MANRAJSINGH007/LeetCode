class Solution {
    public int maxSumDivThree(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int min4 = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            int curr = nums[i];
            sum += nums[i];
            if(curr % 3 == 1){
                if(curr <= min1){
                    min2 = min1;
                    min1 = curr;
                }
                else if(curr < min2){
                    min2 = curr;
                }
            }
            else if(curr % 3 == 2){
                if(curr <= min3){
                    min4 = min3;
                    min3 = curr;
                }
                else if(curr < min4){
                    min4 = curr;
                }
            }
        }
        
        if(sum % 3 == 0) return sum;
        
        if(sum % 3 == 1){
            int min = Integer.MAX_VALUE;
            if(min1 != Integer.MAX_VALUE) min = Math.min(min, min1);
            if(min3 != Integer.MAX_VALUE && min4 != Integer.MAX_VALUE) min = Math.min(min, min3  + min4);
            return sum - min;
        }
        
        else{
            int min = Integer.MAX_VALUE;
            if(min3 != Integer.MAX_VALUE) min = Math.min(min, min3);
            if(min1 != Integer.MAX_VALUE && min2 != Integer.MAX_VALUE) min = Math.min(min, min1  + min2);
            return sum - min;
        }
        
    }
}
