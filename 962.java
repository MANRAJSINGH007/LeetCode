class Solution {
    public int maxWidthRamp(int[] A) {
        
        int n = A.length;
        
        if(n <= 1){
            return 0;
        }
        
        int max = A[0];
        
        for(int i = 0; i < n; i++){
            max = Math.max(max, A[i]);
        }
        
        int[] right = new int[max + 1];
        Arrays.fill(right, 0, max + 1, Integer.MIN_VALUE);
        
        for(int i = 0; i < n; i++){
            int curr = A[i];
            right[curr] = i;
        }
        
        int[] left = new int[max + 1];
        Arrays.fill(left, 0, max + 1, Integer.MAX_VALUE);

        int[] exist = new int[max + 1];
        
        for(int  i = n - 1; i >= 0; i--){
            int curr = A[i];
            left[curr] = i;
            exist[curr] = 1;
            
        }
        
        for(int i = 1; i < max + 1; i++){
            left[i] = Math.min(left[i], left[i - 1]);
        }
        
        for(int i = max - 1; i >= 0; i--){
            right[i] = Math.max(right[i], right[i + 1]);
        }
        
        int maxWidth = 0;
        
        for(int i = 0; i < max + 1; i++){
            
            if(exist[i] == 1){
                maxWidth = Math.max(maxWidth, right[i] - left[i]);
            }
            
        }
        
        return maxWidth;
        
    }
}
