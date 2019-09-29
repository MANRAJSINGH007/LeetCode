class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int n = s.length();
        
        int start = 0;
        int end = 0;
        
        int cost = Math.abs((int)s.charAt(0) - (int)t.charAt(0));
        int len = 0;
        
        while(end < n){
            
            while(end < n && cost <= maxCost){
                if(cost <= maxCost){
                    len = Math.max(len, end - start + 1);
                }
                end++;
                if(end == n) break;
                cost += Math.abs((int)s.charAt(end) - (int)t.charAt(end));
            }
            
            if(end == n) return len;
            
            while(start <= end && cost > maxCost){
                cost -= Math.abs((int)s.charAt(start) - t.charAt(start));
                start++;
            }
        }
        
        return len;
        
    }
}
