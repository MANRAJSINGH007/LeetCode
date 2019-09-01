class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        
        int n =nums.length;
        
        int odd_pointer = 1;
        int even_pointer = 0;
        
        while(even_pointer < n && odd_pointer <= n){
            
            while(odd_pointer < n && nums[odd_pointer]%2 == 1){
                odd_pointer += 2;
            }
            
            while(even_pointer < n && nums[even_pointer]%2 == 0){
                even_pointer += 2;
            }
            
            if(odd_pointer< n && even_pointer < n){
                int temp = nums[odd_pointer];
                nums[odd_pointer] = nums[even_pointer];
                nums[even_pointer] = temp;
                
                odd_pointer += 2;
                even_pointer += 2;
            }
            
        }
        
        return nums;
        
    }
}
