class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int mid = (start + end)/2;
        
        while(start <= end){
            
            mid = (start + end)/2;
            
            if(mid > 0 && mid < n - 1){
                if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];
                if(nums[mid] == nums[mid - 1]){
                    if(mid % 2 == 1) start = mid + 1;
                    else end = mid - 1;
                }
                else{
                    if(mid % 2 == 0) start = mid + 1;
                    else end = mid - 1;
                }
            }
            
            else return nums[mid];
        }
        
        return -1;
        
    }
}
