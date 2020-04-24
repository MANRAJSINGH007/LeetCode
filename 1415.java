class Solution {
    public static List<String> func(int n, int i, int prev, HashMap<Integer, List<String>> map) {
        if(i == n) {
            List<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        if(map.containsKey(i * 10 + prev)) return map.get(i * 10 + prev);
        List<String> curr = new ArrayList<>();
        for(int l = 0; l < 3; l++) {
            if(prev != l) {
                char ch = (char)(l + 97);
                List<String> small = func(n, i + 1, l, map);
                for(int j = 0; j < small.size(); j++) curr.add(ch + small.get(j));
            }
        }
        map.put(i * 10 + prev, curr);
        return curr;
    }
    public String getHappyString(int n, int k) {
        List<String> ans = func(n, 0, 3, new HashMap<>());
        if(ans.size() < k) return "";
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < k; i++) pq.add(ans.get(i));
        for(int i = k; i < n; i++) {
            if(ans.get(i).compareTo(pq.peek()) < 0) {
                pq.poll();
                pq.add(ans.get(i));
            }
        }
        return pq.peek();
    }
}
