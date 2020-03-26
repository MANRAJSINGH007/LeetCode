class Solution {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int ans = 0;
        outer : for(int j = 0; j < n; j++) {
            int curr = nums[j];
            int count = 0;
            int sum = 0;
            if(Math.pow((int)Math.sqrt(curr), 2) == curr) continue outer;
            for(int i = 1; i <= (int)Math.sqrt(curr); i++) {
                if(curr % i == 0) {
                    count += 2;
                    if(count > 4) break;
                    sum += curr / i + i;
                }
            }
            if(count == 4) ans += sum;
        }
        return ans;
    }
}
