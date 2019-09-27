class Solution {
    public int lengthOfLastWord(String s) {
        
        int n = s.length();
        
        int c = 0;
        
        int index = n - 1;
        
        while(index >= 0 && s.charAt(index) == ' ') index--;
        
        for(int i = index; i >= 0; i--){
            if(s.charAt(i) == ' '){
                return c;
            }
            
            c++;
        }
        
        return c;
        
    }
}
