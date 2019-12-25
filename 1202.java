class Solution {
    
    public static void dfs(String s, HashMap<Integer, ArrayList<Integer>> map, boolean[] visited, ArrayList<Integer> list, int curr, ArrayList<Character> ch){
        if(visited[curr]) return;
        visited[curr] = true;
        list.add(curr);
        ch.add(s.charAt(curr));
        if(!map.containsKey(curr)) return;
        ArrayList<Integer> adj = map.get(curr);
        for(int i = 0; i < adj.size(); i++) dfs(s, map, visited, list, adj.get(i), ch);
        return;
    }
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < pairs.size(); i++){
            int s1 = pairs.get(i).get(0), s2 = pairs.get(i).get(1);
            if(!map.containsKey(s1)) map.put(s1, new ArrayList<>());
            if(!map.containsKey(s2)) map.put(s2, new ArrayList<>());
            map.get(s1).add(s2);
            map.get(s2).add(s1);
        }
        boolean[] visited = new boolean[n];
        char[] ans = new char[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                ArrayList<Integer> l1 = new ArrayList<>();
                ArrayList<Character> l2 = new ArrayList<>();
                dfs(s, map, visited, l1, i, l2);
                Collections.sort(l1);
                Collections.sort(l2);
                for(int t = 0; t < l1.size(); t++) ans[l1.get(t)] = l2.get(t);
            }
        }
        return new String(ans);
    }
}
