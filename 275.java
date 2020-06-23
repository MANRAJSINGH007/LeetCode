class Solution {
    public int hIndex(int[] arr) {
        int n = arr.length;
        int start = 0, end = n - 1, ans = 0;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            ans = Math.max(ans, Math.min(arr[mid], n - mid));
            if(arr[mid] >= n - mid) end = mid - 1;
            else start = mid + 1;
        }
        return ans;
    }
}
