class Solution {
    public String removeDuplicateLetters(String s) {
        
        int n = s.length();
        
        if(n == 0) return s;
        
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> seen = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            char curr = s.charAt(i);
            map.put(curr, i);
        }
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < n; i++){
            char curr = s.charAt(i);
            if(seen.contains(curr)) continue;
            while(stack.size() > 0 && (int)stack.peek() > (int)curr && map.get(stack.peek()) > i){
                char rem = stack.pop();
                seen.remove(rem);
            }
            
            stack.push(curr);
            seen.add(curr);
        }
        
        StringBuilder sb = new StringBuilder();
        for (char i : stack) sb.append(i);
        
        return sb.toString();
        
    }
}
