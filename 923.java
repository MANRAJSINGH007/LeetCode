class Solution {
    public int threeSumMulti(int[] arr, int target) {
        
        int n = arr.length;
        int mod = (int)Math.pow(10, 9) + 7;
        long ans = 0;
        Arrays.sort(arr);
        
        for(int i = 0; i < n - 2; i++){
            
            int start = i + 1;
            int end = n - 1;
            
            while(start < end){
                
                int sum = arr[i] + arr[start] + arr[end];
                
                if(sum == target){
                    
                    int count1 = 0, count2 = 0;
                    
                    for(int k = start; k <= end; k++){
                        if(arr[k] == arr[start]) count1++;
                        else break;
                    }
                    
                    for(int k = end; k >= start; k--){
                        if(arr[k] == arr[end]) count2++;
                        else break;
                    }
                    
                    if(arr[start] == arr[end]) ans = (ans + ((end - start + 1) * (end - start))/2 ) % mod;
                    else ans = (ans + (count1 * count2) % mod) % mod;
                    start = start + count1;
                    end = end - count2;
                }
                
                else if(sum < target) start++;
                else end--;
                
            }
            
        }
        
        return (int)ans;
        
    }
}
