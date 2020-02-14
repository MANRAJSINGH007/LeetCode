class Solution {
    
    public static boolean check(int[] arr, int[] brr){
        
        for(int i = 0; i < 26; i++){
            if(arr[i] != brr[i]){
                return false;
            }
        }
        
        return true;
        
    }
    
    public boolean checkInclusion(String s1, String s2) {
        
        int n = s1.length();
        int m = s2.length();
        
        if(m < n){
            return false;
        }
        
        int[] arr = new int[26];
        int[] brr = new int[26];
        
        for(int i = 0; i < n; i++){
            int index = (int)s1.charAt(i) - 97;
            arr[index]++;
            index = (int)s2.charAt(i) - 97;
            brr[index]++;
        }
        
        int start = 0;
        int end = n - 1;
        
        while(end < m){
            
            if(check(arr, brr)){
                return true;
            }
            
            end++;
            if(end == m){
                break;
            }
            
            brr[(int)s2.charAt(end) - 97]++;
            brr[(int)s2.charAt(start) - 97]--;
            start++;
            
        }
        
        return false;
    }
}
