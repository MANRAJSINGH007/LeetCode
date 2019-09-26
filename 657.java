class Solution {
    public boolean judgeCircle(String moves) {
        
        int n = moves.length();
        if(n == 0) return true;
        
        int curr_x = 0;
        int curr_y = 0;
        
        for(int i = 0; i < n; i++){
            
            char curr = moves.charAt(i);
            if(curr == 'L'){
                curr_x--;
            }
            else if(curr == 'R'){
                curr_x++;
            }
            else if(curr == 'U'){
                curr_y++;
            }
            else{
                curr_y--;
            }
            
        }
        
        return curr_x == 0 && curr_y == 0;
        
    }
}
