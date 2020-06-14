class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] prev = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
        }
        for(int i = 0; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[j] != 0 && nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        int index = -1, max = 0;
        for(int i = 0; i < n; i++) {
            if(max < dp[i]) {
                max = dp[i];
                index = i;
            }
        }
        while(index != -1) {
            list.add(nums[index]);
            index = prev[index];
        }
        Collections.sort(list);
        return list;
    }
}
