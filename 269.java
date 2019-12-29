class Solution {
    
    static String ans;
    static int flag = 0;
    
    public static boolean dfs(int[][] g, int curr, int[] visited){
        if(visited[curr] == 2) return false;
        if(visited[curr] == 1){
            flag = 1;
            return true;
        }
        visited[curr] = 1;
        for(int i = 0; i < 26; i++){
            if(g[curr][i] == 1 && dfs(g, i, visited)) return true;
        }
        visited[curr] = 2;
        ans = (char)(97 + curr) + ans;
        return false;
    } 
    
    public String alienOrder(String[] words) {
        int[][] g = new int[26][26];
        ans = "";
        flag = 0;
        int n = words.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < words[i].length(); j++) set.add(words[i].charAt(j) - 'a');
        }
        for(int i = 1; i < n; i++){
            String prev = words[i - 1];
            String curr = words[i];
            for(int j = 0; j < Math.min(curr.length(), prev.length()); j++){
                if(curr.charAt(j) == prev.charAt(j)) continue;
                char c1 = prev.charAt(j);
                char c2 = curr.charAt(j);
                g[c1 - 'a'][c2 - 'a'] = 1;
                break;
            }
        }
        
        int[] visited = new int[26];
        for(int i = 0; i < 26; i++) if(set.contains(i) && visited[i] == 0){
            if(dfs(g, i, visited)) return "";
        }
        return ans;
    }
}
