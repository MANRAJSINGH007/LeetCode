class Solution {
    public int sumOfDigits(int[] A) {
        int n = A.length;
        if(n == 0) return 0;
        int min = A[0];
        for(int i = 0; i < n; i++) min = Math.min(min, A[i]);
        int sum = 0;
        while(min > 0){
            sum += min % 10;
            min /= 10;
        }
        
        return sum % 2 == 1 ? 0 : 1;
    }
}
