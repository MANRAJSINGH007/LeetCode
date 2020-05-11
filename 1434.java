class Solution {
    static int mod = (int)Math.pow(10, 9) + 7;
    public static int func(List<Integer> hats, int i, boolean[] visited, HashMap<Integer, HashSet<Integer>> map, int[][] dp) {
        int mask = 0;
        for(int j = 0; j < visited.length; j++) mask += visited[j] ? (int)Math.pow(2, j) : 0;
        if(mask == Math.pow(2, visited.length) - 1) return 1;
        if(i == hats.size()) return 0;
        if(dp[i][mask] != -1) return dp[i][mask];
        long ans = 0;
        for(int j = 0; j < visited.length; j++) {
            if(visited[j]) continue;
            HashSet<Integer> set = map.get(j);
            if(set.contains(hats.get(i))) {
                visited[j] = true;
                ans = (ans + func(hats, i + 1, visited, map, dp)) % mod;
                visited[j] = false;
            }
        }
        ans = (ans + func(hats, i + 1, visited, map, dp)) % mod;
        return dp[i][mask] = (int)ans;
    }
    public int numberWays(List<List<Integer>> hats) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < hats.size(); i++) {
            map.put(i, new HashSet<>());
            for(int j = 0; j < hats.get(i).size(); j++) {
                set.add(hats.get(i).get(j));
                map.get(i).add(hats.get(i).get(j));
            }
        }
        List<Integer> h = new ArrayList<>(set);
        Collections.sort(h);
        int[][] dp = new int[h.size() + 1][(int)Math.pow(2, hats.size())];
        for(int i = 0; i <= h.size(); i++) {
            for(int j = 0; j < (int)Math.pow(2, hats.size()); j++) dp[i][j] = -1;
        }
        return func(h, 0, new boolean[hats.size()], map, dp);
    }
}
