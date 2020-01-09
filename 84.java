class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        int i = 0;
        while(i < n) {
            int curr = heights[i];
            if(stack.peek() == -1 || heights[stack.peek()] <= curr) stack.push(i);
            else {
                while(stack.peek() != -1 && heights[stack.peek()] >= curr) {
                    int removed = stack.pop();
                    int currArea = heights[removed];
                    currArea *= (i - 1 - stack.peek());
                    maxArea = Math.max(maxArea, currArea);
                }
                stack.push(i);
            }
            i++;
        }
        while(stack.peek()!= -1) {
            int removed = stack.pop();
            int currArea = heights[removed];
            currArea *= (i - 1 - stack.peek());
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
}
