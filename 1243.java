class Solution {
    
    public static boolean check(int[] arr, int[] brr, int n){
        
        for(int i = 1; i < n - 1; i++){
            if(arr[i] != brr[i]) return false;
        }
        
        return true;
        
    }
    
    public List<Integer> transformArray(int[] arr) {
        
        int n = arr.length;
        if(n <= 2){
            List<Integer> ans = new ArrayList<>();
            for(int i = 0; i < n; i++){
                ans.add(arr[i]);
            }
            
            return ans;
        }
        
        List<Integer> ans = new ArrayList<>();
        
        int[] crr = new int[n];
        
        for(int i = 0; i < n; i++) crr[i] = arr[i];
        int j = 0;
        
        while(j == 0 || !check(arr, crr, n)){
            
            j ++;
            arr = crr;
            crr = new int[n];
            for(int i = 0; i < n; i++) crr[i] = arr[i];
            
            for(int i = 1; i < n - 1; i++){
                if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) crr[i]--;
                else if(arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) crr[i]++;
            }
            
        }
        
        
        for(int i = 0; i < n; i++){
            ans.add(arr[i]);
        }

        return ans;
        
    }
}
