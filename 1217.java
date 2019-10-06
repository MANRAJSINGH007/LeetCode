class Solution {
    public int minCostToMoveChips(int[] chips) {
        
        int n = chips.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            count += chips[i] & 1;
        }
        
        return Math.min(count, n - count);
        
    }
}
