class Solution {
    public int evalRPN(String[] tokens) {
        
        int n = tokens.length;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < n; i++){
            String curr = tokens[i];
            int t = curr.length();
            if(curr.charAt(0) == '+' && t == 1) stack.push(stack.pop() + stack.pop());
            else if(curr.charAt(0) == '-' && t == 1) stack.push(-(stack.pop() - stack.pop()));
            else if(curr.charAt(0) == '*' && t == 1) stack.push(stack.pop() * stack.pop());
            else if(curr.charAt(0) == '/' && t == 1) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1 / op2);
            }
            else stack.push(Integer.parseInt(curr));
        }
        
        return stack.pop();
        
    }
}
