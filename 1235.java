class Pair implements Comparable<Pair>{
    int start;
    int end;
    int profit;
    
    Pair(int start, int end, int profit){
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
    
    public int compareTo(Pair b) {
        if(this.start < b.start) return -1;
        if(this.start > b.start) return 1;
        if(this.end < b.end) return -1;
        return 0;
    }
}

class Solution {
    
    public static int search(Pair[] arr, int i, int n){
        
        if(i == -1) return 0;
        
        int start = i + 1;
        int end = n - 1;
        int ans = i + 1;
        
        int mid = (start + end)/2;
        
        while(start <= end){
            mid = (start + end)/2;
            if(arr[i].end <= arr[mid].start){
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        
        return ans;
        
        
    }
    
    public static int func(Pair[] arr, int n, int i, int j, HashMap<Integer, HashMap<Integer, Integer>> map){
        
        if(i == n) return 0;
        
        if(map.containsKey(i)){
            HashMap<Integer, Integer> temp = map.get(i);
            if(temp.containsKey(j)) return temp.get(j);
        }
        
        int p1 = 0;
        int p2 = 0;
        
        if(j == -1 || arr[i].start >= arr[j].end){
            p1 = func(arr, n, search(arr, i, n), i, map) + arr[i].profit;
        }
        
        p2 = func(arr, n, i + 1, j, map);
        
        if(!map.containsKey(i)){
            map.put(i, new HashMap<>());
        }
        
        HashMap<Integer, Integer> temp = map.get(i);
        temp.put(j, Math.max(p1, p2));
        
        return Math.max(p1, p2);
        
    }
    
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int n = profit.length;
        Pair[] arr = new Pair[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = new Pair(startTime[i], endTime[i], profit[i]);
        }
        
        Arrays.sort(arr);
        
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        
        return func(arr, n, 0, -1, map);
        
    }
}
