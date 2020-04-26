class Solution {
    public static int func(int[] ages, int n, int i) {
        int start = 0;
        int end = i - 1;
        int index = -1;
        double marker = 0.5 * ages[i] + 7;
        while(start <= end) {
            int mid = (start + end) / 2;
            if((double)ages[mid] > marker) {
                index = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return index == -1 ? 0 : i - index;
    }
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        Arrays.sort(ages);
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(ages[i], i);
        for(int i = 0; i < n; i++) {
            if((double)ages[i] > 0.5 * ages[i] + 7 ) ans += map.get(ages[i]) - i;
            ans += func(ages, n, i);
        }
        return ans;
    }
}
