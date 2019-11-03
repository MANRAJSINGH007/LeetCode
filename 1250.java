class Solution {
    
    public static int gcd(int a, int b){
        
        if(b > a) return gcd(b, a);
        
        if(b == 0) return a;
        
        return gcd(b, a % b);
        
    }
    
    public boolean isGoodArray(int[] nums) {
        
        int n = nums.length;
        if(n == 1) return nums[0] == 1;
        int gc = nums[0];
        for(int i = 1; i < n; i++){
            gc = gcd(nums[i], gc);
            if(gc == 1) return true;
        }
        
        return false;
        
    }
}
