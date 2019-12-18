class Solution {
    public int fixedPoint(int[] A) {
        int n = A.length;
        int start = 0;
        int end = n - 1;
        int mid = (start + end)/2;
        int ans = Integer.MAX_VALUE;
        while(start <= end){
            mid = (start + end)/2;
            if(A[mid] == mid){
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
            else if(A[mid] > mid) end = mid - 1;
            else start = mid + 1;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
