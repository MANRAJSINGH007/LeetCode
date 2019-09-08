class Solution {
    
    public static int find(int[] arr, int target, int m){
        
        int start = 0;
        int end = m - 1;
        
        int mid = (start + end)/2;
        int ans = -1;
        
        while(start <= end){
            
            mid = (start + end)/2;
            
            if(arr[mid] > target){
                ans = mid;
                end = mid - 1;
            }
            
            else{
                start = mid + 1;
            }
            
        }
        
        return ans;
        
        
    }
    
    public static int function(int[] arr1, int[] arr2, int i, int n, int m, int[][] dp, int prev_index){
        
        if(i == n){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        
        if(i == 0 || arr1[i] > arr1[i - 1]){
            min = function(arr1, arr2, i + 1, n, m, dp, m + 1);
        }
        
        if(i == 0){
            for(int j = 0; j < m; j++){
                int curr = arr1[i];
                arr1[i] = arr2[j];
                int small = function(arr1, arr2, i + 1, n, m, dp, j);
                arr1[i] = curr;
                if(small != Integer.MAX_VALUE){
                    small++;
                    min = Math.min(min, small);
                }
            }
            
            return min;
            
        }
        
        
        if(dp[i][prev_index] != -1){
            return dp[i][prev_index];
        }
        
        
       
        int index = find(arr2, arr1[i - 1], m);
        if(index != -1){
            int curr = arr1[i];
            arr1[i] = arr2[index];
            int small = function(arr1, arr2, i + 1, n, m, dp, index);
            arr1[i] = curr;
            if(small != Integer.MAX_VALUE){
                small++;
                min = Math.min(min, small);
            }
        }
            
        
        
        return dp[i][prev_index] = min;
        
    }
    
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        
        int n = arr1.length;
        int m = arr2.length;
        
        Arrays.sort(arr2);
        
        int min = Integer.MAX_VALUE;
        
        int[][] dp = new int[n][3000];
        
        for(int i = 0; i <n; i++){
            for(int j = 0; j <= 2999; j++){
                dp[i][j] = -1;
            }
        }
        
        int ans = function(arr1, arr2, 0, n, m, dp, -1);
        
        if(ans == Integer.MAX_VALUE){
            ans = -1;
        }
        
        return ans;
        
    }
}
