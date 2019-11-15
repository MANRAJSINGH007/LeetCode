class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        boolean[] mark = new boolean[24 * 60];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);
            if (mark[h * 60 + m]) return 0;
            mark[h * 60 + m] = true;
        }
        
        int min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;
        int prev = -1;
        
        for(int i = 0; i < 24 * 60; i++){
            if(mark[i]){
                first = Math.min(first, i);
                last = Math.max(last, i);
                if(prev != -1) min = Math.min(i - prev, min);
                prev = i;
            }
        }
        
        return Math.min(min, first + 24 * 60 - last);
    }
}
