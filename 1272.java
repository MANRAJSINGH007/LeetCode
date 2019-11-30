class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        
        int n = intervals.length;
        List<List<Integer>> ans = new ArrayList<>();
        
        int start = toBeRemoved[0];
        int end = toBeRemoved[1];
        
        for(int i = 0; i < n; i++){
            if(intervals[i][1] <= start || end <= intervals[i][0]){
                List<Integer> curr = new ArrayList<>();
                curr.add(intervals[i][0]);
                curr.add(intervals[i][1]);
                ans.add(curr);
            } else if(start <= intervals[i][0] && end >= intervals[i][1]){
                continue;
            } else if(start <= intervals[i][0] && end < intervals[i][1]){
                List<Integer> curr = new ArrayList<>();
                curr.add(end);
                curr.add(intervals[i][1]);
                ans.add(curr);
            } else if(start >= intervals[i][0] && end <= intervals[i][1]){  
                List<Integer> curr1 = new ArrayList<>();
                curr1.add(intervals[i][0]);
                curr1.add(start);
                ans.add(curr1);
                List<Integer> curr2 = new ArrayList<>();
                curr2.add(end);
                curr2.add(intervals[i][1]);
                ans.add(curr2);
            } else{
                List<Integer> curr = new ArrayList<>();
                curr.add(intervals[i][0]);
                curr.add(start);
                ans.add(curr);
            }
        }
        
        return ans;
        
    }
}
