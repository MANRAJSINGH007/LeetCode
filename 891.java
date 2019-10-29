class Solution {
    public int sumSubseqWidths(int[] A) {
        
        int mod = (int)Math.pow(10, 9 ) + 7;
        int n = A.length;
        Arrays.sort(A);
        
        long[] power = new long[n];
        power[0] = 1;
        for(int i = 1; i < n; i++) {
            power[i] = power[i - 1] * 2 % mod; 
        }
        
        long ans = 0;
        
        for(int i = 0; i < n; i++) {
            ans = (ans + (power[i] - power[n - 1 - i]) * A[i]) % mod;
        }
        
        return (int)ans;
        
    }
}
