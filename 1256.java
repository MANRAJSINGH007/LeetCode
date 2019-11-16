class Solution {
    public String encode(int num) {
        
        String ans = "";
        while(num >= 2) {
            if(num % 2 == 1)
                ans = "0" + ans;
            else
                ans = "1" + ans;
            num = (num - 1) / 2;
        }
        if(num == 2)
            ans = "1" + ans;
        if(num == 1)
            ans = "0" + ans;
        return ans;
        
    }
}
