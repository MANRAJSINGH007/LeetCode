class Solution {
    public int minDeletionSize(String[] A) {
        
        int n = A.length;
        if(n <= 1) return 0;
        int count = 0;
        int m = A[0].length();
        
        for(int i = 0; i < m; i++){
            for(int j = 1; j < n; j++){
                int diff = A[j].charAt(i) - A[j - 1].charAt(i);
                if(diff < 0){
                    count ++;
                    break;
                }
            }
        }
        
        return count;
    }
}
