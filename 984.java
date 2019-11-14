class Solution {
    public String strWithout3a3b(int A, int B) {
        
        int n = A + B;
        if(n == 0) return "";
        StringBuilder sb = new StringBuilder();
        int c1 = 0; 
        int c2 = 0;
        
        for(int i = 0; i < n; i++){
            if(c1 == 2){
                c2 ++;
                c1 = 0;
                sb.append('b');
                B --;
            }
            else if(c2 == 2){
                c1 ++;
                c2 = 0;
                sb.append('a');
                A --;
            }
            else if(A >= B){
                A --;
                c1 ++;
                sb.append('a');
            }
            else{
                B --;
                c2 ++;
                sb.append('b');
            }
        }
        
        return sb.toString();
        
    }
}
