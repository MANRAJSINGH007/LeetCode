class Solution {
    public static boolean equivalent(String s1, String s2){
        int n = s1.length();
        int diff = 0;
        if(s1.charAt(0) <= s2.charAt(0)) diff = s2.charAt(0) - s1.charAt(0);
        else diff = 'z' - s1.charAt(0) + s2.charAt(0) - 'a' + 1;
        for(int i = 1; i < n; i++){
            int c = 0;
            if(s1.charAt(i) <= s2.charAt(i)) c = s2.charAt(i) - s1.charAt(i);
            else c = 'z' - s1.charAt(i) + s2.charAt(i) - 'a' + 1;
            if(c != diff) return false;
        }
        return true;
    }
    public List<List<String>> groupStrings(String[] strings) {
        int n = strings.length;
        HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int currLength = strings[i].length();
            if(map.get(currLength) == null) map.put(currLength, new HashMap<>());
            HashMap<Integer, ArrayList<Integer>> temp = map.get(currLength);
            if(temp.size() == 0){
                temp.put(i, new ArrayList<>());
                temp.get(i).add(i);
                continue;
            }
            Set<Integer> keys = temp.keySet();
            int keyIndex = -1;
            for(Integer key : keys){
                if(equivalent(strings[key], strings[i])){
                    keyIndex = key;
                    break;
                }
            }
            if(keyIndex == -1){
                temp.put(i, new ArrayList<>());
                temp.get(i).add(i);
            } else{
                temp.get(keyIndex).add(i);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        Set<Integer> k1 = map.keySet();
        for(Integer i : k1){
            Set<Integer> k2 = map.get(i).keySet();
            for(Integer j : k2){
                List<String> t = new ArrayList<>();
                ArrayList<Integer> l = map.get(i).get(j);
                for(int p = 0; p < l.size(); p++) t.add(strings[l.get(p)]);
                ans.add(t);
            }
        }
        return ans;
    }
}
