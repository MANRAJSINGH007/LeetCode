class Solution {
    public boolean isValid(String S) {
        
        int n = S.length();
        Stack<Character> stack = new Stack<>();
        
        int i = 0;
        
        while(i < n){
            
            stack.push(S.charAt(i));
            
            if(stack.size() >= 3){
                
                if(stack.peek() == 'c'){
                    
                    stack.pop();
                    
                    if(stack.peek() == 'b'){
                        stack.pop();
                        
                        if(stack.peek() == 'a'){
                            stack.pop();
                        }
                        
                        else{
                            stack.push('b');
                            stack.push('c');
                        }
                    }
                    
                    else{
                        stack.push('c');
                    }
                }
            }
            
            i++;
        }
        
        return stack.size() == 0;
        
    }
}
