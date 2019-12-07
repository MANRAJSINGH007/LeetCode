class Pair implements Comparable<Pair>{
    int d;
    int p;
    Pair(int d, int p){
        this.d = d;
        this.p = p;
    }
    
    public int compareTo(Pair obj){
        if(this.d < obj.d) return -1;
        else if(this.d > obj.d) return 1;
        if(this.p > obj.p) return -1;
        return 1;
    }
}

class Solution {
    
    public static int findJob(Pair[] arr, int maxDiff){
        
        int start = 0;
        int end = arr.length - 1;
        int index = -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid].d > maxDiff) end = mid - 1;
            else{
                index = Math.max(mid, index);
                start = mid + 1;
            }
        }
        
        return index;
        
    }
    
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        Pair[] arr = new Pair[difficulty.length];
        for(int i = 0; i < difficulty.length; i++){
            arr[i] = new Pair(difficulty[i], profit[i]);
        }
        
        Arrays.sort(arr);
        int max = 0;
        int[] aux = new int[difficulty.length];
        aux[0] = arr[0].p;
        for(int i = 1; i < difficulty.length; i++) aux[i] = Math.max(aux[i - 1], arr[i].p);
        
        for(int i = 0; i < worker.length; i++){
            int j = findJob(arr, worker[i]);
            if(j == -1) continue;
            else max += aux[j];
        }
        
        return max;
    }
}
