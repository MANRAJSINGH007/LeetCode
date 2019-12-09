class Solution {
    
    public static boolean func(String min, String s){
        
        int n = min.length();
        if(s.length() % n != 0) return false;
        String aux = new String(min);
        int index = 0;
        min = "";
        
        while(min.length() < s.length() && aux.equals(s.substring(index, index + n))){
            index += n;
            min += aux;
        }
        
        return min.length() == s.length();
        
    }
    
    public String gcdOfStrings(String s1, String s2) {
        
        int n1 = s1.length();
        int n2 = s2.length();
        String min = s1;
        String other = s2;
        if(n1 > n2){
            min = s2;
            other = s1;
        }
        
        for(int i = 1; i <= min.length(); i++){
            if(min.length() % i == 0){
                if(func(min.substring(0, min.length()/i), other) && func(min.substring(0, min.length()/i), min)) return min.substring(0, min.length()/i);
            }
        }
        
        return "";
        
    }
}
