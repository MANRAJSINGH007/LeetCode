class Solution {
    public int numUniqueEmails(String[] emails) {
        int n = emails.length;
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String[] arr = emails[i].split("@");
            if(!map.containsKey(arr[1])) map.put(arr[1], new HashSet<>());
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < arr[0].length(); j++) {
                if(arr[0].charAt(j) == '+') break;
                if(arr[0].charAt(j) == '.') continue;
                sb.append(arr[0].charAt(j));
            }
            map.get(arr[1]).add(sb.toString());
        }
        int ans = 0;
        Set<String> keys = map.keySet();
        for(String s : keys) ans += map.get(s).size();
        return ans;
    }
}
