class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int n = order.length();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            map.put(order.charAt(i), i);
        }
        
        
        
        for(int  i = 0; i < words.length - 1; i++){
            
            String curr = words[i];
            String next = words[i + 1];
            
            int flag = 0;
            
            for(int j = 0; j < Math.min(curr.length(), next.length()); j++){
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                if(c1 != c2){
                    if(map.get(c1) < map.get(c2)){
                        flag = 1;
                        break;
                    }
                    else{
                        return false;
                    }
                }
            }
            
            if(flag == 0){
                if(curr.length() > next.length()){
                    return false;
                }
            }
            
        }
        
        return true;
        
    }
}
