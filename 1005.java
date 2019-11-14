class Solution {
    public int largestSumAfterKNegations(int[] arr, int k) {
        
        int n = arr.length;
        if(n == 0) return 0;
        if(n == 1) return k % 2 == 0 ? arr[0] : -arr[0];
        Arrays.sort(arr);
        int sum = 0;
        for(int i = 0; i < n; i++) sum += arr[i];
        
        int index = n;
        for(int i = 0; i < n; i++){
            if(arr[i] >= 0){
                index = i;
                break;
            }
        }
        
        if(index == 0){
            if(k % 2 == 0) return sum;
            return sum - arr[0] + (-arr[0]);
        }
        
        if(k <= index){
            
            for(int i = 0; i < k; i++){
                sum -= arr[i];
                sum += -arr[i];
            }
            
            return sum;
        }
        
        for(int i = 0; i < index; i++){
            sum -= arr[i];
            sum += -arr[i];
        }
        
        k -= index;
        if(k % 2 == 0) return sum;
        if(index == n) return sum + 2 * arr[index - 1];
        return Math.max(sum + 2 * arr[index - 1], sum - 2 * arr[index]);
    }
}
