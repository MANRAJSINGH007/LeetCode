class Solution {
    public String reverseOnlyLetters(String S) {
        
        int n = S.length();
        
        char[] ch = S.toCharArray();
        
        int start = 0;
        int end = n - 1;
        
        while(start < end){
            
            int i1 = (int)ch[start];
            int i2 = (int)ch[end];
            
            int flag = 0;
            if(i1 >= 65 && i1 <= 90 || i1 >=97 && i1 <= 122){
                
            }
            else{
                flag = 1;
                start++;
            }
            if(i2 >= 65 && i2 <= 90 || i2 >=97 && i2 <= 122){
                
            }
            else{
                flag = 1;
                end--;
            }
            
            if(flag == 0){
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }
        
        return new String(ch);
        
    }
}
