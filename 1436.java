class Solution {
    public String destCity(List<List<String>> paths) {
        int n = paths.size();
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0 ; i < n; i++) map.put(paths.get(i).get(0), paths.get(i).get(1));
        String curr = map.get(paths.get(0).get(0));
        while(map.containsKey(curr)) curr = map.get(curr);
        return curr;
    }
}
