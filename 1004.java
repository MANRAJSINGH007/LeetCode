class Solution {
    public int longestOnes(int[] A, int k) {
        
        int n = A.length;
        
        int start = 0;
        int end = 0;
        
        int count = 0;
        
        while(end < n && count < k){
            
            if(A[end] == 0){
                count++;
            }
            
            end++;
        }
        
        if(end == n) return n;
        
        while(end < n && A[end] == 1){
            end++;
        }
        
        if(end == n) return end;
        
        int max = end - start;
        
        // now A[end] is definitely 0.
        
        while(end < n){
            
            while(start < end && A[start] == 1){
                start++;
            }
            
            start++;
            end++;
            
            while(end < n && A[end] == 1){
                end++;
            }
            
            max = Math.max(max, end - start);
            
        }
        
        return max;
        
    }
}
