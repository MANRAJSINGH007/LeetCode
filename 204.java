class Solution {
    public int countPrimes(int n) {
        n--;
        if(n <= 1) return 0;
        int count = 0;
        boolean[] prime = new boolean[n + 1];
        for(int i = 2; i <= n; i++) prime[i] = true;
        for(int i = 2; i <= n; i++) {
            if(prime[i]) {
                count++;
                for(int j = (int)Math.pow(i, 2); j <= n; j += i) prime[j] = false;
            }
        }
        return count;
    }
}
