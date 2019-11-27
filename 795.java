class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        
        int n = A.length;
        int start = 0;
        int ans = 0;
        int prev = -1;
        
        for(int i = 0; i < n; i++){
            if(A[i] > R){
                start = i + 1;
            } else if(A[i] >= L && A[i] <= R){
                ans += i - start + 1;
                prev = i;
            } else{
                if(prev >= start){
                    ans += i - start + 1;
                    ans -= (i - prev);
                }
            }
        }
        
        return ans;
    }
}
