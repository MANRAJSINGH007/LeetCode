class Solution {
    
    static List<String> ans;
    
    public static void getWords(HashMap<String, ArrayList<String>> adj, String curr, HashSet<String> visited){
        
        visited.add(curr);
        ArrayList<String> currAdj = adj.get(curr);
        
        for(int i = 0; i < currAdj.size(); i++){
            if(!visited.contains(currAdj.get(i))) getWords(adj, currAdj.get(i), visited);
        }
        
        return;
    }
    
    public static void func(String[] sent, int m, int i, HashMap<String, ArrayList<String>> map, String s){
        
        if(i == m){
            ans.add(s);
            return ;
        }
        
        if(i != 0) s += " ";
        
        String currWord = sent[i];
        if(!map.containsKey(currWord)){
            func(sent, m, i + 1, map, s + currWord);
            return;
        }
        
        HashSet<String> visited = new HashSet<>();
        getWords(map, currWord, visited);
        ArrayList<String> curr = new ArrayList<>(visited);
        Collections.sort(curr);
        for(int j = 0; j < curr.size(); j++) func(sent, m, i + 1, map, s + curr.get(j));
        
    }
    
    
    public List<String> generateSentences(List<List<String>> arr, String text) {
        
        int n = arr.size();
        ans = new ArrayList<>();
        HashMap<String, ArrayList<String>> adj = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            String s1 = arr.get(i).get(0);
            String s2 = arr.get(i).get(1);
            if(!adj.containsKey(s1)){
                adj.put(s1, new ArrayList<>());
                adj.get(s1).add(s1);
            }
            adj.get(s1).add(s2);
            if(!adj.containsKey(s2)){
                adj.put(s2, new ArrayList<>());
                adj.get(s2).add(s2);
            }
            adj.get(s2).add(s1);
        }
        
        String[] sent = text.split(" ");
        int m = sent.length;
        func(sent, m, 0, adj, "");
        return ans;
    }
}
