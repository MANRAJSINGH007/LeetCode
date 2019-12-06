class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        
        int n = s.length();
        int count = 1;
        List<List<Integer>> ans = new ArrayList<>();
        if(n <= 2) return new ArrayList<>();
        int st = 0;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == s.charAt(i - 1)) count++;
            else{
                if(count > 2){
                    List<Integer> l = new ArrayList<>();
                    l.add(st);
                    l.add(i - 1);
                    ans.add(l);
                }
                
                count = 1;
                st = i;
            }
        }
        
        if(count > 2){
            List<Integer> l = new ArrayList<>();
            l.add(st);
            l.add(n - 1);
            ans.add(l);
        }
        
        return ans;
        
    }
}
