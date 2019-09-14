class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int n = seats.length;
        
        int[] right = new int[n];
        
        for(int i = n - 1; i >= 0; i--){
            if(seats[i] == 1){
                right[i] = 0;
            }
            else{
                if(i != n - 1) right[i] = right[i + 1] + 1;
            }
        }
        
        int left_max = 0;
        
        int max = 0;
        
        for(int i = 0; i < n; i++){
            if(seats[i] == 1){
                left_max = 0;
            }
            else{
                left_max += 1;
                if(i != 0 && i != n - 1) max = Math.max(max, Math.min(left_max, right[i]));
                
                else if(i == 0){
                    max = Math.max(max, right[i]);
                }
                
                else{
                    max = Math.max(max, left_max);
                }
            }
        }
        
        return max;
    }
}
