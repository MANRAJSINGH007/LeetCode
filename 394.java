class Solution {
    public String decodeString(String s) {
        
        int n = s.length();
        
        String ans = "";
        
        int count = 0;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < n; i++){
            
            char curr = s.charAt(i);
            
            if(curr == ']'){
                String temp = "";
                while(stack.peek() != '['){
                    temp = stack.pop() + temp;
                }
                
                stack.pop();
                
                int freq = 0;
                
                String t = "";
                
                while(stack.size()>0 && (int)stack.peek() >= 48 && (int)stack.peek() <= 57){
                    t = stack.pop() + t;
                }
                
                freq = Integer.parseInt(t);
                
                for(int j = 0; j < freq; j++){
                    for(int k = 0; k < temp.length(); k++){
                        stack.push(temp.charAt(k));
                    }
                }
                
            }
            
            else{
                stack.push(s.charAt(i));
            }
            
        }
        
        while(stack.size()>0){
            
            ans = stack.pop() + ans;
        }
        
        return ans;
        
    }
}
