class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        
        int n = arr.length;
        long sum = 0;
        
        int mod = (int)Math.pow(10, 9) + 7;
        
        for(int i = 0; i < n; i++){
            sum += (long)arr[i];
        }
        
        long maxSum = 0;
        
        int flag = 0;
        
        if(sum > 0){
            flag = 1;
            maxSum = sum * k;
        }
        
        long totalSum = sum;
        
        long currSum = 0;
        
        for(int i = 0; i < n; i++){
            
            if((long)arr[i] + currSum >= 0){
                currSum += (long)arr[i];
                maxSum = Math.max(maxSum, currSum);
            }
            
            else{
                currSum = 0;
                maxSum = Math.max(maxSum, currSum);
            }
        }
        
        long prefixSum = 0;
        long suffixSum = 0;
        
        sum = 0;
        
        for(int i = 0; i < n; i++){
            sum += (long)arr[i];
            prefixSum = Math.max(prefixSum, sum);
        }
        
        sum = 0;
        
        for(int i = n - 1; i >= 0; i--){
            sum += (long)arr[i];
            suffixSum = Math.max(suffixSum, sum);
        }
                
        maxSum = Math.max(maxSum, suffixSum + prefixSum);
        
        if(flag == 1){
            maxSum = Math.max(maxSum, (k - 2) * totalSum + suffixSum + prefixSum);
        }
        
        return (int)(maxSum % mod);
    }
}
