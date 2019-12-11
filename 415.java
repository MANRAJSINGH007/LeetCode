class Solution {
    public String addStrings(String num1, String num2) {
        
        int n1 = num1.length();
        int n2 = num2.length();
        int carry = 0;
        String ans = "";
        
        int i1 = n1 - 1;
        int i2 = n2 - 1;
        
        while(i1 >= 0 && i2 >= 0){
            int sum = Integer.parseInt("" + num1.charAt(i1)) + Integer.parseInt("" + num2.charAt(i2)) + carry;
            carry = sum / 10;
            sum = sum % 10;
            ans = Integer.toString(sum) + ans;
            i1--;
            i2--;
        }
        
        while(i1 >= 0){
            int sum = Integer.parseInt("" + num1.charAt(i1)) + carry;
            carry = sum / 10;
            sum = sum % 10;
            ans = Integer.toString(sum) + ans;
            i1--;
        }
        
        while(i2 >= 0){
            int sum = Integer.parseInt("" + num2.charAt(i2)) + carry;
            carry = sum / 10;
            sum = sum % 10;
            ans = Integer.toString(sum) + ans;
            i2--;
        }
        
        if(carry == 1) ans = "1" + ans;
        
        return ans;
        
    }
}
