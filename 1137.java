class Solution {
    public int tribonacci(int n) {
        
        if(n == 0 || n == 1) return n;
        if(n == 2) return 1;
        
        int x1 = 0;
        int x2 = 1;
        int x3 = 1;
        
        for(int i = 3; i <= n; i++){
            int sum = x1 + x2 + x3;
            x1 = x2;
            x2 = x3;
            x3 = sum;
        }
        
        return x3;
        
    }
}
