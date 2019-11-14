class Solution {
    public int findMinArrowShots(int[][] points) {
        
        int n = points.length;
        if(n <= 1) return n;
        
        Arrays.sort(points, new Comparator<int[]>() {
          public int compare(int[] entry1, int[] entry2) {
            if (entry1[0] > entry2[0]) 
                return 1; 
            else
                return -1; 
          } 
        });
        
        int count = 1;
        int[] prev = points[0];
        for(int i = 1; i < n; i++){
            if(points[i][0] > prev[1]){
                count ++;
                prev = points[i];
            }
            else{
                prev[0] = Math.max(prev[0], points[i][0]);
                prev[1] = Math.min(prev[1], points[i][1]);
            }
        }
        
        return count;
    }
}
