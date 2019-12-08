class Solution {
    
    public static long check(int[] nums, int n, long mid){
        
        long ans = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] % mid == 0){
                ans += (long)(nums[i]/mid);
                continue;
            } else{
                ans += (long)(nums[i]/mid + 1);
            }
        }
        
        return (int)ans;
        
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        
        int n = nums.length;
        long sum = 0;
        for(int i = 0; i < n; i++) sum += (long)nums[i];
        
        long start = 1;
        long end = sum;
        
        long ans = Long.MAX_VALUE;
        
        while(start <= end){
            long mid = (start) + (end - start)/2;
            // System.out.print(start + " " + end + " " + mid);
            long c = check(nums, n, mid);
            if(c > (long)threshold) start = mid + 1;
            else{
                ans = Math.min(mid, ans);
                end = mid - 1;
            }
        }
        
        return (int)ans;
        
    }
}
