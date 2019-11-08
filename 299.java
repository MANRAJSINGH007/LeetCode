class Solution {
    public String getHint(String secret, String guess) {
        
        int n = secret.length();
        int[] count = new int[11];
        
        for(int i = 0; i < n; i++){
            char curr = secret.charAt(i);
            count[(int)curr - 48] ++;
        }
        
        int a = 0;
        int b = 0;
        
        for(int i = 0; i < n; i++){
            char curr = guess.charAt(i);
            if(curr == secret.charAt(i)) {
                a ++;
                count[(int)curr - 48] --;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(guess.charAt(i) != secret.charAt(i) && count[(int)guess.charAt(i) - 48] > 0){
                b ++;
                count[(int)guess.charAt(i) - 48] --;
            }
        }
        
        return Integer.toString(a) + 'A' + Integer.toString(b) + 'B';
        
        
    }
}
