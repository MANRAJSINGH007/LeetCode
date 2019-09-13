class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        
        int n = timeSeries.length;
        if(n == 0){
            return n;
        }
        int time = 0;
        int prevRangeEnd = 0;
        int prevStart = -1;
        
        for(int i = 0; i < n; i++){
            int currStart = timeSeries[i];
            if(currStart >= prevRangeEnd){
                time += duration;
                prevRangeEnd = currStart + duration;
                prevStart = currStart;
            }
            else{
                time += currStart - prevStart;
                prevRangeEnd += currStart - prevStart;
                prevStart = currStart;
            }
        }
        
        return time;
        
    }
}
