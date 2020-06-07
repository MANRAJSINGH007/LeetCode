class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int mid = (n - 1) / 2;
        int left = 0, right = n - 1, count = 0;
        int[] ans = new int[k];
        int it = 0;
        while(count < k && left <= right) {
            count++;
            int x = Math.abs(arr[mid] - arr[left]), y = Math.abs(arr[mid] - arr[right]);
            if(x > y) ans[it++] = arr[left++];
            else ans[it++] = arr[right--];
        }
        return ans;
    }
}
