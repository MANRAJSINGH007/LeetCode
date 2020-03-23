class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int m = reservedSeats.length, ans = 0;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < m; i++) {
            if(!map.containsKey(reservedSeats[i][0])) map.put(reservedSeats[i][0], new HashSet<>());
            map.get(reservedSeats[i][0]).add(reservedSeats[i][1]);
        }
        ans += 2 * n - 2 * map.size();
        Set<Integer> keys = map.keySet();
        for(Integer i : keys) {
            boolean flag = false;
            HashSet<Integer> reserved = map.get(i);
            if(!reserved.contains(2) && !reserved.contains(3) && !reserved.contains(4) && !reserved.contains(5)) {
                ans++;
                flag = true;
            }
            if(!reserved.contains(6) && !reserved.contains(7) && !reserved.contains(8) && !reserved.contains(9)) {
                ans++;
                flag = true;
            }
            if(!flag && !reserved.contains(4) && !reserved.contains(5) && !reserved.contains(6) && !reserved.contains(7)) ans++;
        }
        return ans;
    }
}
