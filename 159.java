class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if(n <= 2) return n;
        int max = 2;
        int start = 0, end = 0;
        int l1 = n + 1, l2 = n + 1;
        char c1 = '.', c2 = '.';
        while(end < n){
            while(end < n){
                char curr = s.charAt(end);
                if(c1 == '.' || curr == c1){
                    l1 = end;
                    c1 = curr;
                    max = Math.max(max, end - start + 1);
                } else if(c2 == '.' || curr == c2){
                    l2 = end;
                    c2 = curr;
                    max = Math.max(max, end - start + 1);
                } 
                else break;
                end++;
            }
            
            if(end == n) break;
            int minIndex = Math.min(l1, l2);
            if(minIndex == l1){
                start = minIndex + 1;
                end++;
                max = Math.max(max, end - start);
                c1 = c2;
                l1 = l2;
                c2 = s.charAt(end - 1);
                l2 = end - 1;
            } else{
                start = minIndex + 1;
                end++;
                max = Math.max(max, end - start);
                c2 = s.charAt(end - 1);
                l2 = end - 1;
            }
        }
        
        return max;
    }
}
