class Solution {
    public int[] closestDivisors(int num) {
        int minAbs = Integer.MAX_VALUE;
        int[] ans = new int[2];
        for(int i = 1; i <= (int)Math.sqrt(num + 2); i++) {
            int x = i;
            if(x <= (int)Math.sqrt(num + 1) && (num + 1) % x == 0) {
                int currDiff = Math.abs(((num + 1) / x) - x);
                if(currDiff < minAbs) {
                    minAbs = currDiff;
                    ans[0] = x;
                    ans[1] = (num + 1) / x;
                }
            } else if((num + 2) % x == 0) {
                int currDiff = Math.abs(((num + 2) / x) - x);
                if(currDiff < minAbs) {
                    minAbs = currDiff;
                    ans[0] = x;
                    ans[1] = (num + 2) / x;
                }
            }
        }
        return ans;
    }
}
