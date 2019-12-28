class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        if(n == 0) return arr;
        int max = arr[n - 1];
        for(int i = n - 2; i >= 0; i--){
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
        }
        arr[n - 1] = -1;
        return arr;
    }
}
