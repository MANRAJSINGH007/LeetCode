class Solution {
    public int maxNumberOfBalloons(String text) {
        
        int n = text.length();
        int[] arr = new int[26];
        String s = "balloon";
        
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            arr[(int)curr - 97]++;
        }
        
        int[] brr = new int[26];
        
        for(int i = 0; i < n; i++){
            char curr = text.charAt(i);
            brr[(int)curr - 97]++;
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < 26; i++){
            if(arr[i] != 0){
                min = Math.min(min, brr[i]/arr[i]);
            }
        }
        
        
        return min;
        
    }
}
