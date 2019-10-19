class Solution {
    public int missingNumber(int[] arr) {
        
        int n = arr.length;
        int sum = 0;
        
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }
        
        return (((n + 1) * (arr[0] + arr[n - 1])) / 2) -sum;
        
    }
}
