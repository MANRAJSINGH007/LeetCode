class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] brr = new int[n];
        for(int i = 0; i < n; i++) brr[i] = arr[i];
        Arrays.sort(brr);
        int[] rank = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        int val = 0;
        for(int i = 0; i < n; i++) {
            if(!map.containsKey(brr[i])) {
                val++;
                map.put(brr[i], val);
            }
        }
        for(int i = 0; i < n; i++) rank[i] = map.get(arr[i]);
        return rank;
    }
}
