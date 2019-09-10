class Solution {
    public int compress(char[] chars) {
        
        int n = chars.length;
        
        if(n == 1){
            return 1;
        }
        
        int i = 0;
        int j = 1;
        int index = 0;
        int count = 1;
        
        while(i < n && j < n){
            
            while(j < n && chars[j] == chars[i]){
                count++;
                j++;
            }
            
            if(count == 1){
                chars[index] = chars[i];
                index++;
                i = j;
                j++;
            }
            
            else{
                chars[index] = chars[i];
                index++;
                String number = Integer.toString(count);
                for(int k = 0; k < number.length(); k++){
                    chars[index + k] = number.charAt(k);
                }
                index += number.length();
                i = j;
                j++;
                count = 1;
            }
            
        }
        
        if(i == n -1 && j == n){
            chars[index] = chars[i];
            index++;
        }
        
        return index;
        
    }
}
