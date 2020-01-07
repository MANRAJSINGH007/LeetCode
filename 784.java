class Solution {
    
    static List<String> ans;
    
    public static void func(String s, int n, int i, String curr){
        
        if(i == n){
            ans.add(curr);
            return;
        }
        
        int ascii = (int)s.charAt(i);
        if(ascii >= 48 && ascii <= 57){
            func(s, n, i + 1, curr + s.charAt(i));
            return;
        }
        
        if(ascii <= 90){
            func(s, n, i + 1, curr + s.charAt(i));
            char c = (char)((int)s.charAt(i) - 65 + 97);
            func(s, n, i + 1, curr + c);
            return ;
        }
        
        func(s, n, i + 1, curr + s.charAt(i));
        char c = (char)((int)s.charAt(i) + 65 - 97);
        func(s, n, i + 1, curr + c);
        return ;
        
    }
    
    public List<String> letterCasePermutation(String s) {
        ans = new ArrayList<>();
        func(s, s.length(), 0, "");
        return ans;
    }
}
