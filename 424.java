class Solution {
    
    public static boolean check(int[] arr, int k){
        int max = 0;
        int index = 0;
        int sum = 0;
        for(int i = 0; i < 26; i++){
            if(arr[i] > max){
                max = arr[i];
                index = i;
            }
            sum += arr[i];
        }
        sum -= arr[index];
        if(sum <= k) return true;
        return false;
    }
    
    public int characterReplacement(String s, int k) {
        
        int n = s.length();
        if(n <= 1) return n;
        int[] arr = new int[26];
        int start = 0;
        int end = 0;
        int max = 1;
        arr[s.charAt(0) - 'A']++;
        
        while(end < n){
            while(end < n && check(arr, k)){
                max = Math.max(end - start + 1, max);
                end++;
                if(end == n) break;
                arr[s.charAt(end) - 'A']++;
            }
            
            while(start <= end && !check(arr, k)){
                arr[s.charAt(start) - 'A']--;
                start++;
            }
            
            if(check(arr, k)){
                if(end == n) max = Math.max(max, end - start);
                else max = Math.max(max, end - start + 1);
            }
        }
        
        return max;
    }
}
