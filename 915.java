class Solution {
    public int partitionDisjoint(int[] A) {
        
        int n = A.length;
        
        if(n == 2) return 1;
        
        int max = A[0];
        
        int start = 1;
        
        while(start < n &&  A[start] < max){
            start++;
        }
        
        int min = A[n - 1];
        int end = n -1;
        
        while(end >= start && min >= max){
            end--;
            min = Math.min(min, A[end]);
        }
        
        if(end < start) return start;
        
        int temp = max;
        
        for(int j = start; j <= end; j++){
            temp = Math.max(A[j], temp);
        }
        
        for(int k = n - 1; k > end; k--){
            if(A[k] < temp) return k + 1;
        }
        
        return end + 1;
    }
}
