class Solution {
    public int numberOfBoomerangs(int[][] points) {
        
        int n = points.length;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            int[] p1 = points[i];
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                int[] p2 = points[j];
                int d = (int)Math.pow(p1[0] - p2[0], 2) + (int)Math.pow(p1[1] - p2[1], 2);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            
            for(int val : map.values()){
                ans += val * (val - 1);
            }
            
            map.clear();
        }
        
        return ans;
        
    }
}
