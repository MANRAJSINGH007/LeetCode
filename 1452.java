class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        HashMap<Integer, HashSet<String>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
            for(int j = 0; j < favoriteCompanies.get(i).size(); j++) map.get(i).add(favoriteCompanies.get(i).get(j));
        }
        List<Integer> ans = new ArrayList<>();
        outer : for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                HashSet<String> s1 = map.get(i);
                HashSet<String> s2 = map.get(j);
                Iterator<String> it = s1.iterator();
                boolean flag = false;
                while(it.hasNext()) {
                    if(!s2.contains(it.next())) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) continue outer;
            }
            ans.add(i);
        }
        return ans;
    }
}
