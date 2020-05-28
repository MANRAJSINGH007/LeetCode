class Solution {
    public static String func(int[] cost, int target, String[] dp) {
        if(target == 0) return "";
        if(dp[target] != null) return dp[target];
        String max = "0";
        for(int i = 0; i < 9; i++) {
            if(target >= cost[i]) {
                String curr = func(cost, target - cost[i], dp);
                if(curr.equals("0")) continue;
                curr = Integer.toString(i + 1) + curr;
                if(max.length() > curr.length()) continue;
                if(max.equals("0") || curr.length() > max.length() || curr.length() == max.length() && max.compareTo(curr) < 0) max = curr;
            }
        }
        return dp[target] = max;
    }
    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target + 1];
        return func(cost, target, dp);
    }
}
