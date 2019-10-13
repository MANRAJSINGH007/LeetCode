class Solution {
    public int balancedStringSplit(String s) {
        
        int n = s.length();
        
        int count1 = 0;
        int count2 = 0;
        
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'L') count1++;
            else if(s.charAt(i) == 'R') count2++;
            
            if(count1 == count2){
                count++;
                count1 = 0;
                count2 = 0;
            }
        }
        
        return count;
        
    }
}
