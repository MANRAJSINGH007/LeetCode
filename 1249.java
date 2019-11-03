class Solution {
    public String minRemoveToMakeValid(String s) {
        
        int n = s.length();
        if(n == 0) return s;
        StringBuilder sb = new StringBuilder();
        
        HashSet<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < n; i++){
            
            char curr = s.charAt(i);
            
            if(curr == '('){
                stack.push(i);
            }
            
            else if(curr == ')'){
                if(stack.size() > 0){
                    stack.pop();
                }
                else{
                    set.add(i);
                }
            }
            
            else continue;
        }
        
        while(stack.size() > 0){
            set.add(stack.pop());
        }
        
        for(int i = 0; i < n; i++){
            if(!set.contains(i)){
                sb.append("" + s.charAt(i));
            }
        }
        
        return sb.toString();
        
    }
}
