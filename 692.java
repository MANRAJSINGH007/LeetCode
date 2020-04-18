class Pair {
    String word;
    int freq;
    Pair(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                if(p1.freq < p2.freq) return -1;
                if(p2.freq < p1.freq) return 1;
                if(p1.word.compareTo(p2.word) < 0) return 1;
                return -1;
            }
        });
        for(int i = 0; i < n; i++) {
            if(!map.containsKey(words[i])) map.put(words[i], 1);
            else {
                int count = map.get(words[i]);
                count++;
                map.put(words[i], count);
            }
        }
        Set<String> keys = map.keySet();
        int j = 0;
        for(String s : keys) {
            if(j == k) break;
            pq.add(new Pair(s, map.get(s)));
            j++;
            map.put(s, 0);
        }
        for(String s : keys) {
            if(map.get(s) == 0) continue;
            if(map.get(s) > pq.peek().freq) {
                pq.poll();
                pq.add(new Pair(s, map.get(s)));
            } else if(map.get(s) == pq.peek().freq && pq.peek().word.compareTo(s) > 0) {
                pq.poll();
                pq.add(new Pair(s, map.get(s)));
            }
        }
        List<String> ans = new ArrayList<>();
        while(pq.size() > 0) ans.add(0, pq.poll().word);
        return ans;
        
    }
}
