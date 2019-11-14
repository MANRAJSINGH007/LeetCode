class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        
        int n = tokens.length;
        if(n == 0) return 0;
        int score = 0, max = 0;
        Arrays.sort(tokens);
        
        int start = 0;
        int end = n - 1;
        while(start < end){
            
            if(P >= tokens[start]){
                score ++;
                P -= tokens[start];
                start ++;
            }
            
            else if(score > 0){
                score --;
                P += tokens[end];
                end --;
            }
            
            else end --;
            
            max = Math.max(max, score);
        }
        
        if(start == end && P >= tokens[start]) max = Math.max(max, score + 1);
        
        return max;
    }
}
