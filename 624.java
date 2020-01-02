class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = max1;
        int min2 = min1;
        int i1 = -1, i2 = -1, i3 = -1, i4 = -1;
        
        for(int i = 0; i < n; i++) {
            int e1 = arrays.get(i).get(0);
            int e2 = arrays.get(i).get(arrays.get(i).size() - 1);
            if(e2 >= max1) {
                max2 = max1;
                max1 = e2;
                i2 = i1;
                i1 = i;
            } else if(e2 >= max2) {
                max2 = e2;
                i2 = i;
            }
            if(e1 <= min1) {
                min2 = min1;
                min1 = e1;
                i4 = i3;
                i3 = i;
            } else if(e1 <= min2) {
                min2 = e1;
                i4 = i;
            }
        }
        
        if(i1 != i3) return Math.abs(max1 - min1);
        return Math.max(Math.abs(max1 - min2), Math.abs(max2 - min1));
    }
}
