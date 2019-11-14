class Pair {
    char curr;
    int currFreq;
    Pair(char curr, int currFreq){
        this.curr = curr;
        this.currFreq = currFreq;
    }
}

class PairComparator implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        if(p1.currFreq > p2.currFreq) return -1;
        return 1;
    }
}

class Solution {
    public String reorganizeString(String S) {
        
        int n = S.length();
        if(n == 0) return "";
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            char curr = S.charAt(i);
            int count = 1;
            if(map.containsKey(curr)) count += map.get(curr);
            map.put(curr, count);
        }
        
        Set<Character> keys = map.keySet();
        for(Character c : keys){
            pq.add(new Pair(c, map.get(c)));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(pq.size() > 1){
            Pair p1 = pq.poll();
            sb.append(p1.curr);
            p1.currFreq --;
            Pair p2 = pq.poll();
            sb.append(p2.curr);
            p2.currFreq --;
            if(p1.currFreq != 0) pq.add(p1);
            if(p2.currFreq != 0) pq.add(p2);
        }
        
        if(pq.size() == 1 && pq.peek().currFreq > 1) return "";
        
        if(pq.size() > 0) sb.append(pq.poll().curr);
        
        return sb.toString();
    }
}
