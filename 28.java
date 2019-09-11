class Solution {
    public int strStr(String haystack, String needle) {
        
        int n = haystack.length();
        int m = needle.length();
        
        if(m == 0){
            return 0;
        }
        
        if(n == 0 || n < m){
            return -1;
        }
        
        for(int i = 0; i < n - m + 1; i++){
            
            int curr = i;
            int j = 0;
            while(curr < n && j < m && haystack.charAt(curr) == needle.charAt(j)){
                curr++;
                j++;
            }
            
            if(curr == n && j != m){
                return -1;
            }
            
            if(j == m){
                return i;
            }
        }
        
        return -1;
        
    }
}
