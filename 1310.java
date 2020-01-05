class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] pre = new int[n];
        int[] ans = new int[queries.length];
        int xor = 0;
        for(int i = 0; i < n; i++) {
            pre[i] = xor ^ arr[i];
            xor = pre[i];
        }
        for(int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if(l == 0) {
                ans[i] = pre[r];
                continue;
            }
            ans[i] = pre[l - 1] ^ pre[r];
        }
        return ans;
    }
}
