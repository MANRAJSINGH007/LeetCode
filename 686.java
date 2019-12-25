class Solution {
    public int repeatedStringMatch(String A, String B) {
        
        String x = new String(A);
        int count = 1;
        while(x.length() < B.length()){
            x += A;
            count++;
        }
        
        int i1 = 0, i2 = 0;
        for(int i = 0; i < x.length(); i++){
            i1 = i;
            i2 = 0;
            while(i1 < x.length() && i2 < B.length() && x.charAt(i1) == B.charAt(i2)){
                i1++;
                i2++;
            }
            if(i2 == B.length()) return count;
        }
        
        count++;
        x += A;
        for(int i = 0; i < x.length(); i++){
            i1 = i;
            i2 = 0;
            while(i1 < x.length() && i2 < B.length() && x.charAt(i1) == B.charAt(i2)){
                i1++;
                i2++;
            }
            if(i2 == B.length()) return count;
        }
        
        return -1;
    }
}
