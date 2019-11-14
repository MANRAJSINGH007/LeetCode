class Solution {
    public int countSegments(String s) {
        int n = s.length();
        int count = 0;
        int i = 0;
        while(i < n){
            while(i < n && s.charAt(i) == ' ') i ++;
            if(i == n) return count;
            count ++;
            while(i < n && s.charAt(i) != ' ') i ++;
        }
        
        return count;
    }
}
