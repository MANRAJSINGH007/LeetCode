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
    public String frequencySort(String S) {
        
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
        
        while(pq.size() > 0){
            Pair p = pq.poll();
            for(int j = 0; j < p.currFreq; j++) sb.append(p.curr);
        }
        
        return sb.toString();
    }
}
