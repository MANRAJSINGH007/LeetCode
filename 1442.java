class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length, ans = 0, pre = 0;
        int[] prefix = new int[n];
        for(int i = 0; i < n; i++) {
            pre ^= arr[i];
            prefix[i] = pre;
        }
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j; k < n; k++) {
                    int t = i == 0 ? 0 : prefix[i - 1];
                    int x1 = prefix[j - 1] ^ t;
                    int x2 = prefix[k] ^ prefix[j - 1];
                    if(x1 == x2) ans++;
                }
            }
        }
        return ans;
    }
}
