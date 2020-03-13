class Solution {
    public int numTimesAllBlue(int[] light) {
        int n = light.length, ans = 0;
        long currMax = 0;
        long currSum = 0;
        for(int i = 0; i < n; i++) {
            currMax = Math.max(currMax, (long)light[i]);
            currSum += (long)light[i];
            if(currSum == (currMax * (currMax + 1)) / 2) ans++;
        }
        return ans;
    }
}
