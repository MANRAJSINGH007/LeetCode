class Solution {
    public static int checkMin(int[] arr, int n, int val) {
        int sum = 0;
        for(int i = 0; i < n; i++) sum += Math.min(val, arr[i]);
        return sum;
    }
    public int findBestValue(int[] arr, int target) {
        int n = arr.length;
        int max = arr[0];
        for(int i = 1; i < n; i++) max = Math.max(max, arr[i]);
        int ans = -1;
        int minAbs = Integer.MAX_VALUE;
        int start = 0, end = max;
        while(start <= end) {
            int  mid = (start + end) / 2;
            int temp = checkMin(arr, n, mid);
            int x = Math.abs(temp - target);
            if(temp < target) {
                start = mid + 1;
                if(x < minAbs || x == minAbs && mid < ans) {
                    minAbs = x;
                    ans = mid;
                }
            }
            else if(temp == target) return mid;
            else {
                end = mid - 1;
                if(x < minAbs || x == minAbs && mid < ans) {
                    minAbs = x;
                    ans = mid;
                }
            }
        }
        return ans;
    }
}
