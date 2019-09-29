class Solution {
    public String removeDuplicates(String s, int k) {
        
        int n = s.length();
        
        if(k == 1) return "";
        
        Stack<Character> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        for(int i = 0; i < n; i++){
            
            char curr = s.charAt(i);
            
            if(stack1.size() == 0){
                stack1.push(curr);
                stack2.push(1);
            }
            else if(stack1.peek() == curr && stack2.peek() == k - 1){
                for(int j = 0; j < k - 1; j++){
                    stack1.pop();
                    stack2.pop();
                }
            }
            else{
                if(stack1.size() > 0 && stack1.peek() == curr){
                    stack1.push(curr);
                    stack2.push(stack2.peek() + 1);
                }
                else{
                    stack1.push(curr);
                    stack2.push(1);
                }
            }
            
        }
        
        String ans = "";
        
        while(stack1.size() > 0){
            ans = stack1.pop() + ans;
        }
        
        return ans;
        
    }
}
