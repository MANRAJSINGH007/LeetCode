class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        List<Integer> ans = new ArrayList<>();
        
        // need to solve 2 equations
        // 4 * jumbo + 2 * small = tomatoSlices, jumbo + small = cheeseSlices
        
        if(tomatoSlices % 2 == 1) return ans;
        
        int jumbo = tomatoSlices - 2 * cheeseSlices;
        if(jumbo < 0 || jumbo % 2 == 1) return ans;
        
        jumbo /= 2;
        
        int small = cheeseSlices - jumbo;
        if(small < 0) return ans;
        
        ans.add(jumbo);
        ans.add(small);
        
        return ans;
        
    }
}
