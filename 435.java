class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        int n = intervals.length;
        if(n <= 1) return 0;
        
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] interval1, int[] interval2){
                if(interval1[0] > interval2[0]) return 1;
                else if(interval1[0] == interval2[0]){
                    if(interval1[1] > interval2[1]) return 1;
                }
                return -1;
            }
        });
        
        int count = 0;
        int prev = intervals[0][1];
        for(int i = 1; i < n; i++){
            if(intervals[i][0] >= prev) prev = intervals[i][1];
            else{
                count ++;
                prev = Math.min(prev, intervals[i][1]);
            }
        }
        
        return count;
        
    }
}
