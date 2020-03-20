class Pair {
    int sp;
    int ef;
    Pair(int sp, int ef) {
        this.sp = sp;
        this.ef = ef;
    }
}
class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++) arr[i] = new Pair(speed[i], efficiency[i]);
        Arrays.sort(arr, new Comparator<Pair>(){
            public int compare(Pair o1, Pair o2) {
                return o2.ef - o1.ef;
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long res = 0;
        long total = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            total += arr[i].sp;
            min = arr[i].ef;
            res = Math.max(res, total * min);
            pq.add(arr[i].sp);
        }
        for(int  i = k; i < n; i++) {
            if(arr[i].sp > pq.peek()) {
                total -= pq.poll() - arr[i].sp;
                pq.add(arr[i].sp);
                min = arr[i].ef;
                res = Math.max(res, total * min);
            }
        }
        return (int)(res % 10_00_00_00_07);
    }
}
