class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int count = 1;
            if(map.containsKey(arr[i])) count += map.get(arr[i]);
            map.put(arr[i], count);
        }
        Set<Integer> keys = map.keySet();
        for(Integer key : keys) list.add(map.get(key));
        Collections.sort(list);
        int ans = 0, i = list.size() - 1;
        int freq = 0;
        while(i >= 0 && freq < n/2) {
            ans++;
            freq += list.get(i);
            i--;
        }
        return ans;
    }
}
