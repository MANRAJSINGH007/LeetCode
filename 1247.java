class Solution {
    public int minimumSwap(String s1, String s2) {
        
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 != n2) return -1;
        
        int count1 = 0;
        int count2 = 0;
        
        for(int i = 0; i < n1; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(s1.charAt(i) == 'x'){
                    count1 ++;
                }
                else{
                    count2 ++;
                }
            }
        }
        
        if((count1 + count2) % 2 == 1) return -1;
        
        int ans = 0;
        ans += count1/2 + count2/2;
        
        if(count1 % 2 == 0) return ans;
        
        return ans + 2;
        
    }
}
