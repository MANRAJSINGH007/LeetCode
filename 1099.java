class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        int n = A.length;
        if(n < 2) return -1;
        Arrays.sort(A);
        int start = 0, end = n - 1;
        int ans = -1;
        while(start < end){
            int sum = A[start] + A[end];
            if(sum >= K) end--;
            else{
                ans = Math.max(ans, sum);
                start++;
            }
        }
        
        return ans;
    }
}
