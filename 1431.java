class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int max = candies[0];
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) max = Math.max(candies[i], max);
        for(int i = 0; i < n; i++) {
            if(extraCandies + candies[i] >= max) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
}
