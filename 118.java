class Solution {
    public List<List<Integer>> generate(int n) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        if(n == 0) return list;
        
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        
        List<Integer> prev = list.get(0);
        prev.add(1);
        
        if(n == 1) return list;
        
        prev = list.get(1);
        prev.add(1);
        prev.add(1);
        
        if(n == 2) return list;
        
        for(int i = 2; i < n; i++){
            List<Integer> curr = list.get(i);
            
            curr.add(1);
            for(int j = 0; j < prev.size() - 1; j++){
                curr.add(prev.get(j) + prev.get(j + 1));
            }
            
            curr.add(1);
            prev = curr;
            
        }
        
        return list;
    }
}
