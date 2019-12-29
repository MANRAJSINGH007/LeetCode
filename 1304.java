class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        if(n == 0) return new int[0];
        if(n % 2 == 1){
            ans[0] = 0;
            int k = 1;
            for(int i = 1; i < n; i += 2){
                ans[i] = k;
                ans[i + 1] = -k;
                k++;
            }
            return ans;
        } else{
            int k = 1;
            for(int i = 0; i < n; i += 2){
                ans[i] = k;
                ans[i + 1] = -k;
                k++;
            }
            return ans;
        }
    }
}
