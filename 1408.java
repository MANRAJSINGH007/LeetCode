class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        outer : for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                if(words[j].indexOf(words[i]) != -1) {
                    ans.add(words[i]);
                    continue outer;
                }
            }
        }
        return ans;
    }
}
