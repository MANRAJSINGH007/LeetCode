class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        
        int n1 = A.length;
        int n2 = B.length;
        
        int sum1 = 0;
        int sum2 = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < n1; i++) sum1 += A[i];
        for(int i = 0; i < n2; i++){
            sum2 += B[i];
            set.add(B[i]);
        }
        
        for(int i = 0; i < n1; i++){
            int t1 = sum1 - A[i];
            int t2 = sum2 + A[i];
            if((t2 - t1) % 2 == 0 && set.contains((t2 - t1)/2)){
                int[] ans = new int[2];
                ans[0] = A[i];
                ans[1] = (t2 - t1)/2;
                return ans;
            }
        }
        
        return new int[0];
        
    }
}
