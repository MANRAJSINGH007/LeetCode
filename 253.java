class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] t : intervals) {
            map.put(t[0], map.getOrDefault(t[0], 0) + 1);
            map.put(t[1], map.getOrDefault(t[1], 0) - 1);
        }
        int res = 0, cur = 0;
        for (int v : map.values()) {
            res = Math.max(res, cur += v);
        }
        return res;
    }
}
