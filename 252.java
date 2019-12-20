class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        if(n <= 1) return true;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] t1, int[] t2){
                return t1[1] <= t2[1] ? -1 : 1;
            }
        });
        
        for(int i = 1; i < n; i++) if(intervals[i][0] < intervals[i - 1][1]) return false;
        return true;
    }
}
