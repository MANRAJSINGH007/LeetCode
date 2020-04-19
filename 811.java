class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        int n = cpdomains.length;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String[] arr = cpdomains[i].split(" ");
            if(!map.containsKey(arr[1])) map.put(arr[1], Integer.parseInt(arr[0]));
            else map.put(arr[1], map.get(arr[1]) + Integer.parseInt(arr[0]));
            for(int j = 0; j < arr[1].length(); j++) {
                if(arr[1].charAt(j) == '.') {
                    String x = arr[1].substring(j + 1);
                    if(!map.containsKey(x)) map.put(x, Integer.parseInt(arr[0]));
                    else map.put(x, map.get(x) + Integer.parseInt(arr[0]));
                }
            }
        }
        List<String> ans = new ArrayList<>();
        Set<String> keys = map.keySet();
        for(String s : keys) {
            ans.add(Integer.toString(map.get(s)) + " " + s);
        }
        return ans;
    }
}
