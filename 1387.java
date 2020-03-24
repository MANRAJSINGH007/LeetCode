class Pair {
    int power;
    int val;
    Pair(int power, int val) {
        this.power = power;
        this.val = val;
    }
}
class Solution {
    public static int getPower(int num) {
        int ans = 0;
        while(num != 1) {
            if(num % 2 == 0) num /= 2;
            else num = num * 3 + 1;
            ans++;
        }
        return ans;
    }
    public int getKth(int lo, int hi, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(Pair p1, Pair p2) {
                if(p1.power != p2.power) return p2.power - p1.power;
                return p2.val - p1.val;
            }
        });
        for(int  i = lo; i <= hi; i++) {
            int curr = getPower(i);
            if(pq.size() < k) pq.add(new Pair(curr, i));
            else if(pq.peek().power > curr) {
                pq.poll();
                pq.add(new Pair(curr, i));
            }
        }
        return pq.peek().val;
    }
}
