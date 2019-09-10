class Solution {
    public String countAndSay(int n) {
        
        String ans = "1";
        if(n == 1){
            return ans;
        }
        
        ans = "11";
        if(n == 2){
            return ans;
        }
        
        for(int k = 3; k <= n; k++){
            
            String temp = "";
            int i = 0;
            int j = 1;
            int currLength = ans.length();
            
            int c = 1;
            
            while(i < currLength && j < currLength){
                
                while(j < currLength && ans.charAt(i) == ans.charAt(j)){
                    c++;
                    j++;
                }
                
                temp += Integer.toString(c) + ans.charAt(i);
                i = j;
                j++;
                c = 1;
                
            }
            
            if(i == currLength - 1 && j == i + 1){
                temp+= Integer.toString(1) + ans.charAt(i);
            }
            
            ans = temp;
            
        }
        
        return ans;
        
    }
}
