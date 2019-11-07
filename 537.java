class Solution {
    public String complexNumberMultiply(String a, String b) {
        
        int n1 = a.length();
        int n2 = b.length();
        n1 --;
        n2 --;
        
        int i1 = 0;
        int i2 = 0;
        
        int sign1 = 1;
        int sign2 = 1;
        int sign3 = 1;
        int sign4 = 1;
        
        if(a.charAt(i1) == '-'){
            sign1 = -1;
            i1 ++;
        }
        else if(a.charAt(i1) == '+'){
            i1 ++;
        }
        
        if(b.charAt(i2) == '-'){
            sign2 = -1;
            i2 ++;
        }
        else if(b.charAt(i2) == '+'){
            i2 ++;
        }
        
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        
        while(i1 < n1 && a.charAt(i1) != '+' && a.charAt(i1) != '-') s1.append(a.charAt(i1++));
        while(i2 < n2 && b.charAt(i2) != '+' && b.charAt(i2) != '-') s2.append(b.charAt(i2++));
        
        i1 ++;
        i2 ++;
        
        if(a.charAt(i1) == '-'){
            sign3 = -1;
            i1 ++;
        }
        if(b.charAt(i2) == '-'){
            sign4 = -1;
            i2 ++;
        }
        
        StringBuilder s3 = new StringBuilder();
        StringBuilder s4 = new StringBuilder();
        
        while(i1 < n1 && a.charAt(i1) != '+' && a.charAt(i1) != '-') s3.append(a.charAt(i1++));
        while(i2 < n2 && b.charAt(i2) != '+' && b.charAt(i2) != '-') s4.append(b.charAt(i2++));
        
        int x1 = sign1 * sign2 * Integer.parseInt(s1.toString()) * Integer.parseInt(s2.toString());
        x1 += sign3 * sign4 * (-1) * Integer.parseInt(s3.toString()) * Integer.parseInt(s4.toString());
        
        int x2 = sign1 * sign4 * Integer.parseInt(s1.toString()) * Integer.parseInt(s4.toString());
        x2 += sign2 * sign3 * Integer.parseInt(s2.toString()) * Integer.parseInt(s3.toString());
        
        String ans = Integer.toString(x1);
        ans += '+';
        return ans += Integer.toString(x2) + 'i';
    }
}
