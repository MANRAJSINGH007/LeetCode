class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        int n = name.length();
        int m = typed.length();
        
        int i = 0; 
        int j = 0;
        
        while(i < n && j < m){
            
            char c1 = name.charAt(i);
            char c2 = typed.charAt(j);
            
            if(c1 != c2){
                return false;
            }
            
            int count1 = 0;
            
            while(i < n && name.charAt(i) == c1){
                count1++;
                i++;
            }
            
            int count2 = 0;
            
            while(j < m && count2 < count1 && typed.charAt(j) == c1){
                count2++;
                j++;
            }
            
            if(count2 != count1){
                return false;
            }
            
            while(j < m && typed.charAt(j) == c1){
                j++;
            }
            
        }
        
        return (i == n && j == m);
        
    }
}
