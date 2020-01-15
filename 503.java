class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        if(n == 0) return new int[0];
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) ans[i] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);
        for(int i = 2 * n - 2; i >= 0; i--) {
            int curr = nums[i % n];
            if(stack.size() > 0 && nums[stack.peek()] <= curr) {
                while(stack.size() > 0 && nums[stack.peek()] <= curr) stack.pop();
                if(stack.size() > 0 && ans[i % n] == -1) ans[i % n] = nums[stack.peek()]; 
            } else if(ans[i % n] == -1) ans[i % n] = nums[stack.peek()];
            stack.push(i % n);
        }
        return ans;
    }
}
