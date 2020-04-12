class Solution {
    public static int search(int[] arr, int val) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == val) return i;
        }
        return -1;
    }
    public int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        int[] arr = new int[m];
        int[] ans = new int[n];
        for(int i = 0; i < m; i++) arr[i] = i + 1;
        for(int i = 0; i < n; i++) {
            int index = search(arr, queries[i]);
            ans[i] = index;
            for(int j = index - 1; j >= 0; j--) arr[j + 1] = arr[j];
            arr[0] = queries[i];
        }
        return ans;
    }
}
