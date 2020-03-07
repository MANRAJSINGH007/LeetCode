class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int n = A.length, sum = 0, m = Integer.MIN_VALUE;;
        int[] prefix = new int[n], sufix = new int[n];
        boolean flag = false;
        for(int i = 0; i < n; i++) {
            if(A[i] >= 0) flag = true;
            else m = Math.max(m, A[i]);
            sum += A[i];
            if(i == 0) {
                prefix[i] = sum;
                continue;
            }
            prefix[i] = Math.max(prefix[i - 1], sum);
        }
        if(!flag) return m;
        sum = 0;
        sufix[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--) {
            sum += A[i + 1];
            sufix[i] = Math.max(sufix[i + 1], sum);
        }
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            currSum += A[i];
            maxSum = Math.max(currSum, maxSum);
            if(currSum < 0) currSum = 0;
        }
        for(int i = 0; i < n; i++) {
            int temp = Math.max(prefix[i] + sufix[i], sufix[i]);
            temp = Math.max(temp, prefix[i]);
            maxSum = Math.max(temp, maxSum);
        }
        return maxSum;
    }
}
