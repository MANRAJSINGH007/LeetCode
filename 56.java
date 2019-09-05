class Pair{
    int start;
    int end;
    
    Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class Solution {
    
    public static ArrayList<Pair> mergeIntervals(int[][] intervals, int n){
              
        ArrayList<Pair> list = new ArrayList<>();
        
        list.add(new Pair(intervals[0][0], intervals[0][1]));
        
        Pair prev = list.get(0);
        
        int count = 1;
        
        for(int i = 1; i < n; i++){
            
            int s = intervals[i][0];
            int e = intervals[i][1];
            
            if(s > prev.end){
                list.add(new Pair(s, e));
                count += 1;
                prev = list.get(count - 1);
            }
            
            else{
                list.set(count - 1, new Pair(prev.start, Math.max(e, prev.end)));
                prev = list.get(count - 1);
            }
        }
        
        return list;
        
    }
    
    public int[][] merge(int[][] intervals) {
        
        int n = intervals.length;
        
        if(n <= 1){
            return intervals;
        }
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        
        ArrayList<Pair> list = mergeIntervals(intervals, n);
        
        int[][] ans = new int[list.size()][2];
        
        for(int i = 0; i < list.size(); i++){
            ans[i][0] = list.get(i).start;
            ans[i][1] = list.get(i).end;
        }
        
        return ans;
        
        
    }
}
