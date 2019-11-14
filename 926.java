class Solution {
    public int minFlipsMonoIncr(String S) {
        
        int n = S.length();
        int count0 = 0;
        int count1 = 0;
        
        for(int i = 0; i < n; i++){
            if(S.charAt(i) == '0') count0 ++;
            else count1 ++;
        }
        
        int min = Math.min(count0, count1);
        int curr0 = 0;
        int curr1 = 0;
        
        for(int i = 0; i < n; i++){
            if(S.charAt(i) == '0') curr0 ++;
            else curr1 ++;
            min = Math.min(min, curr1 + count0 - curr0);
        }
        
        return min;
        
    }
}
