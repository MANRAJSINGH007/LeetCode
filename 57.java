class Pair{
    int start;
    int end;
    Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int n = intervals.length;
        
        if(n == 0){
            int[][] ans = new int[1][2];
            ans[0][0] = newInterval[0];
            ans[0][1] = newInterval[1];
            return ans;
        }
        
        ArrayList<Pair> list = new ArrayList<>();
        
        int flag = 0;
        
        for(int i = 0; i < n; i++){
            
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            
            if(flag == 1){
                if(currStart > list.get(list.size() - 1).end){
                    list.add(new Pair(currStart, currEnd));
                }
                else{
                    list.set(list.size() - 1, new Pair(list.get(list.size() - 1).start, Math.max(list.get(list.size() - 1).end, currEnd)));
                }
            }
            
            else{
                if(newInterval[0] > currEnd){
                    list.add(new Pair(currStart, currEnd));
                }
                else if(newInterval[1] < currStart){
                    list.add(new Pair(newInterval[0], newInterval[1]));
                    list.add(new Pair(currStart, currEnd));
                    flag = 1;
                }
                else{
                    flag = 1;
                    list.add(new Pair(Math.min(currStart, newInterval[0]), Math.max(currEnd, newInterval[1])));
                }
            }
            
        }
        
        if(flag == 0){
            list.add(new Pair(newInterval[0], newInterval[1]));
        }
        
        int[][] ans = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            ans[i][0] = list.get(i).start;
            ans[i][1] = list.get(i).end;
        }
        
        return ans;
        
    }
}
