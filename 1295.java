class Solution {
    
    public static int log(int num){
        int prod = 1;
        int count = 0;
        while(prod < num){
            prod *= 10;
            count++;
        }
        if(prod == num) count++;
        return count;
    }
    
    public int findNumbers(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            if((log(nums[i])) % 2 == 0) count++;
        }
        return count;
    }
}
