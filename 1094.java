class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int n = trips.length;
        
        if(n == 0){
            return true;
        }
        
        if(n == 1){
            return trips[0][0] <= capacity;
        }
        
        int[] aux = new int[1001];
        
        for(int i = 0; i < n; i++){
            int start = trips[i][1];
            int end = trips[i][2];
            aux[start] += trips[i][0];
            aux[end] -= trips[i][0];
        }
        
        int sum = 0;
        
        for(int i = 0; i < 1001; i++){
            sum += aux[i];
            if(sum > capacity){
                return false;
            }
        }
        
        return true;
        
    }
}
