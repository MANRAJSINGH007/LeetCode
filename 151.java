class Solution {
    public String reverseWords(String s) {
        
        int n = s.length();
        if(n == 0) return "";
        int start = 0;
        int end = n - 1;
        StringBuilder ans1 = new StringBuilder();
        StringBuilder ans2 = new StringBuilder();
        int flag = 0;
        int it = 0;
        
        while(start <= end){
            
            it ++;
            StringBuilder st = new StringBuilder();
            StringBuilder ed = new StringBuilder();
            
            while(start <= end && s.charAt(start) == ' ') start ++;
            while(end > start && s.charAt(end) == ' ') end --;
            
            if(start > end) break;
            
            while(start <= end && s.charAt(start) != ' '){
                st.append(s.charAt(start));
                start ++;
            }
            
            while(end > start && s.charAt(end) != ' '){
                ed.insert(0, s.charAt(end));
                end --;
                flag = 1;
            }
            
            if(it != 1) st.append(" ");
            ans1.insert(0, st);
            
            if(flag == 1 && start <= end){
                ed.append(" ");
                ans2.append(ed);
            }
        }
        
        if(flag == 0) return ans1.toString();
        System.out.println("hello");
        return ans2.append(ans1.toString()).toString();
        
    }
}
