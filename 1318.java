class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        for(int i = 1; i <= 32; i++) {
            int b1 = 0, b2 = 0, b3 = 0;
            if(((a >> (i - 1)) & 1) >= 1) b1 = 1;
            if(((b >> (i - 1)) & 1) >= 1) b2 = 1;
            if(((c >> (i - 1)) & 1) >= 1) b3 = 1;
            if(b3 == 0 && (b1 == 1 || b2 == 1)) count += b1 + b2;
            else if(b3 == 1 && b1 == 0 && b2 == 0) count++;
        }
        return count;
    }
}
