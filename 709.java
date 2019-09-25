class Solution {
    public String toLowerCase(String str) {
        
        int n = str.length();
        if(n == 0) return str;
        
        char[] ch = str.toCharArray();
        
        for(int i = 0; i < ch.length; i++){
            int index = (int)ch[i] + 32;
            if(index >=97 && index <= 122)
                ch[i] = (char)index;
        }
        
        return new String(ch);
    }
}
