class Solution {
    
    public static int findParent(int[] parent, int i){
        
        if(parent[i] == i) return i;
        
        return findParent(parent, parent[i]);
        
    }
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        int n = s.length();
        char[] ch = s.toCharArray();
        
        int[] parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < pairs.size(); i++){
            int sv = pairs.get(i).get(0);
            int ev = pairs.get(i).get(1);
            int p1 = findParent(parent, sv);
            int p2 = findParent(parent, ev);
            if(p1 != p2){
                parent[p1] = p2;
            }
        }
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            int p = findParent(parent, i);
            if(!map.containsKey(p)) map.put(p, new ArrayList<>());
            ArrayList<Integer> curr = map.get(p);
            curr.add(i);
        }
        
        Set<Integer> keys = map.keySet();
        
        for(Integer p : keys){
            
            ArrayList<Integer> indexes = map.get(p);
            
            boolean[] graph = new boolean[n];
            int[] count = new int[26];
            
            for(int j = 0; j < indexes.size(); j++){
                graph[indexes.get(j)] = true;
                count[(int)s.charAt(indexes.get(j)) - 97]++;
            }
            
            int c = 0;
            int start = 0;
            
            for(int j = 0; j < n; j++){
                if(graph[j]){
                    while(count[start] == 0){
                        start++;
                    }
                    c++;
                    ch[j] = (char)(start + 97);
                    count[start]--;
                    if(c == indexes.size()) break;
                }
            }
            
        }
        
        return new String(ch);
        
    }
}
