class Solution {
    public static int inf = Integer.MAX_VALUE;
    public static int func(List<Integer> price, List<Integer> needs, int n, List<List<Integer>> special, int m, HashMap<Integer, Integer> map) {
        int memo = 0;
        for(int i = 0; i < n; i++) {
            memo *= 10;
            memo += needs.get(i);
        }
        if(map.containsKey(memo)) return map.get(memo);
        if(memo == 0) return 0;
        int min = inf;
        for(int i = 0; i < n; i++) {
            if(needs.get(i) == 0) continue;
            needs.set(i, needs.get(i) - 1);
            int small = func(price, needs, n, special, m, map);
            if(small != inf) min = Math.min(min, small + price.get(i));
            needs.set(i, needs.get(i) + 1);
        }
        outer : for(int i = 0; i < m; i++) {
            List<Integer> curr = special.get(i);
            for(int j = 0; j < n; j++) if(needs.get(j) < curr.get(j)) continue outer;
            for(int j = 0; j < n; j++) needs.set(j, needs.get(j) - curr.get(j));
            int small = func(price, needs, n, special, m, map);
            if(small != inf) min = Math.min(min, small + curr.get(curr.size() - 1));
            for(int j = 0; j < n; j++) needs.set(j, needs.get(j) + curr.get(j));
        }
        map.put(memo, min);
        return min;
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size(), m = special.size();
        return func(price, needs, n, special, m, new HashMap<>());
    }
}
