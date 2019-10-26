class Solution {
    public String removeOuterParentheses(String S) {
        
        int n = S.length();
        Stack<Integer> stack = new Stack<>();
        
        boolean[] check = new boolean[n];
        
        for(int i = 0; i < n; i++){
            char curr = S.charAt(i);
            if(curr == '('){
                stack.push(i);
            }
            else{
                if(stack.size() == 1){
                    check[stack.pop()] = true;
                    check[i] = true;
                }
                else{
                    stack.pop();
                }
                
            }
        }
        
        String ans = "";
        
        for(int i = 0; i < n; i++){
            if(!check[i]) ans += S.charAt(i);
        }
        
        return ans;
        
    }
}
