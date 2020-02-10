class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(!map.containsKey(arr[i])) map.put(arr[i], new ArrayList());
            map.get(arr[i]).add(i);
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while(q.size() > 0) {
            int[] pair = q.remove();
            if(pair[0] == n - 1) return pair[1];
            if(pair[0] + 1 < n && !visited[pair[0] + 1]) {
                if(pair[0] + 1 == n - 1) return pair[1] + 1;
                q.add(new int[]{pair[0] + 1, pair[1] + 1});
                visited[pair[0] + 1] = true;
            }
            if(pair[0] - 1 >= 0 && !visited[pair[0] - 1]) {
                if(pair[0] - 1 == n - 1) return pair[1] + 1;
                q.add(new int[]{pair[0] - 1, pair[1] + 1});
                visited[pair[0] - 1] = true;
            }
            List<Integer> possible = map.get(arr[pair[0]]);
            for(int i = possible.size() - 1; i >= 0; i--) {
                if(possible.get(i) == n - 1) return pair[1] + 1;
                if(!visited[possible.get(i)]) {
                    q.add(new int[]{possible.get(i), pair[1] + 1});
                    visited[possible.get(i)] = true;
                }
            }
        }
        return -1;
    }
}
