class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int n = letters.length;
        int start = 0;
        int end = n - 1;
        
        char ans = '.';
        
        while(start <= end){
            int mid = (start + end)/2;
            if(letters[mid] <= target) start = mid + 1;
            else{
                ans = letters[mid];
                end = mid - 1;
            }
        }
        
        return ans == '.' ? letters[0] : ans;
        
    }
}
