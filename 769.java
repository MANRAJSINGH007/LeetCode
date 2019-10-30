class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int n = arr.length;
        if(n <= 1) return n;
        int chunks = 1, max = 0;
        
        for(int i = 0; i < n; i++){
            max = Math.max(max, arr[i]);
            if(i == max){
                max ++;
                chunks ++;
            }
        }
        
        return chunks - 1;
    }
}
