class Solution {
    public int distributeCandies(int[] candies) {
        
        int n = candies.length;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            set.add(candies[i]);
        }
        
        return Math.min(n/2, set.size());
        
    }
}
