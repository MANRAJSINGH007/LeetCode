class Solution {
    public int calPoints(String[] ops) {
        int n = ops.length;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            String curr = ops[i];
            int ascii = (int)curr.charAt(0);
            if(curr.length() >= 2 || ascii >= 48 && ascii <= 57) stack.push(Integer.parseInt(curr));
            else if(curr.charAt(0) == '+') {
                int temp1 = stack.pop();
                int temp2 = stack.peek();
                stack.push(temp1);
                stack.push(temp1 + temp2);
            } else if(curr.charAt(0) == 'C') stack.pop();
            else stack.push(2 * stack.peek());
        }
        while(stack.size() > 0) ans += stack.pop();
        return ans;
    }
}
