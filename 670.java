class Solution {
    public int maximumSwap(int num) {
        
        String s = Integer.toString(num);
        
        int n = s.length();
        
        char[] ch = s.toCharArray();
        
        int index = -1;
        
        for(int i = 0; i < n - 1; i++){
            if((int)ch[i] < (int)ch[i + 1]){
                index = i + 1;
                break;
            }
        }
        
        if(index == -1) return num;
        
        int max = (int)ch[index] - 48;
        int maxIndex = index;
        
        for(int k = index + 1; k < n; k++){
            max = Math.max(max, (int)ch[k] - 48);
            if(max == (int)ch[k] - 48) maxIndex = k;
        }
        
        for(int k = 0; k < index; k++){
            if((int)ch[k] - 48 < max){
                int curr = (int)ch[k] - 48;
                ch[k] = (char)(max + 48);
                ch[maxIndex] = (char)(curr + 48);
                String str = new String(ch);
                return Integer.parseInt(str);
            }
        }
        
        return 0;
        
    }
}
