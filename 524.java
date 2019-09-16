class Solution {
    
    public static boolean compare(String x, String y){
        
        for(int i = 0; i < x.length(); i++){
            if((int)x.charAt(i) < (int)y.charAt(i)){
                return true;
            }
            else if((int)y.charAt(i) < (int)x.charAt(i)){
                return false;
            }
        }
        
        return false;
        
    }
    
    public static int func(String x, String y){
        
        int n = x.length();
        int m = y.length();
        
        int j = 0;
        
        for(int i = 0; i < n; i++){
            
            if(x.charAt(i) == y.charAt(j)){
                j++;
            }
            
            if(j == m){
                return j;
            }
        }
               
        return 0;
    }
    
    public String findLongestWord(String s, List<String> d) {
        
        int n = d.size();
        
        String ans = "";
        
        for(int i = 0; i < n; i++){
            int max = func(s, d.get(i));
            if(max > ans.length()){
                ans = d.get(i);
            }
            else if(max != 0 && max == ans.length()){
                if(compare(d.get(i), ans)){
                    ans = d.get(i);
                }
            }
        }
        
        return ans;
    }
}
