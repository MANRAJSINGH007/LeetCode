class Solution {
    public int[] shortestToChar(String s, char c) {
        
        int n = s.length();
        if(n == 0) return new int[0];
        
        int[] distance = new int[n];
        for(int i = 0; i < n; i++){
            distance[i] = n;
        }
        
        int index = -1;
        
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == c){
                distance[i] = 0;
                index = i;
            }
            else if(index != -1){
                distance[i] = i - index;
            }
        }
        
        index = -1;
        
        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == c){
                index = i;
            }
            else if(index != -1){
                distance[i] = Math.min(distance[i], index - i);
            }
        }
        
        return distance;
    }
}
