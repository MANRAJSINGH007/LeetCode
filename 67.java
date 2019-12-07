class Solution {
    public String addBinary(String s1, String s2) {
        
        int n1 = s1.length();
        int n2 = s2.length();
        
        String ans = "";
        
        int i1 = n1 - 1;
        int i2 = n2 - 1;
        int carry = 0;
        
        while(i1 >= 0 || i2 >= 0){
            int sum = 0;
            sum += carry;
            if(i1 >= 0 && s1.charAt(i1) == '1') sum++;
            if(i2 >= 0 && s2.charAt(i2) == '1') sum++;
            carry = sum/2;
            sum = sum % 2;
            if(sum == 0) ans = '0' + ans;
            else ans = '1' + ans;
            if(i1 >= 0) i1--;
            if(i2 >= 0) i2--;
        }
        
        if(carry == 1) ans = '1' + ans;
        
        return ans;
        
    }
}
