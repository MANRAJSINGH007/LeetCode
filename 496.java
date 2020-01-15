class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m == 0) return new int[0];
        int[] ans = new int[m];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);
        map.put(nums2[n - 1], -1);
        for(int i = n - 2; i >= 0; i--) {
            if(nums2[i] > nums2[stack.peek()]) {
                while(stack.size() > 0 && nums2[stack.peek()] < nums2[i]) stack.pop();
                if(stack.size() > 0) map.put(nums2[i], nums2[stack.peek()]);
            } else map.put(nums2[i], nums2[stack.peek()]);
            stack.push(i);
        }
        for(int i = 0; i < m; i++) {
            if(!map.containsKey(nums1[i])) ans[i] = -1;
            else ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
