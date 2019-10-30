class Pair implements Comparable<Pair>{
    int start;
    int end;
    
    Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
    
    public int compareTo(Pair pair){
        return this.start - pair.start;
    }
}

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        
        int n = intervals.length;
        if(n == 0) return new int[0];
        
        int[] ans = new int[n];
        if(n == 1) {
            ans[0] = -1;
            return ans;
        }
        
        Pair[] aux = new Pair[n];
        HashMap<Pair, Integer> use = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            aux[i] = new Pair(intervals[i][0], intervals[i][1]);
            use.put(aux[i], i);
        }
        
        Arrays.sort(aux);
        
        for(int i = 0; i < n; i++){
            
            int currEnd = intervals[i][1];
            int ans_index = n;
            int start = 0;
            int end = n - 1;
            int mid = (start + end)/2;
            
            while(start <= end){
                mid = (start + end)/2;
                if(aux[mid].start >= currEnd){
                    if(ans_index > use.get(aux[mid])){
                        ans_index = use.get(aux[mid]);
                    }
                    end = mid - 1;
                }
                
                else start = mid + 1;
            }
            
            if(ans_index == n) ans[i] = -1;
            else ans[i] = ans_index;
        }
        
        return ans;
    }
}
