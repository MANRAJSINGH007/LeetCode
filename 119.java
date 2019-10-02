class Solution {
    public List<Integer> getRow(int n) {
        
        n++;
        
        List<Integer> list = new ArrayList<>();
        
        if(n == 0) return list;
        
        list.add(1);        
        if(n == 1) return list;
        
        list.add(1);        
        if(n == 2) return list;
        
        for(int i = 2; i < n; i++){
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            
            for(int j = 0; j < list.size() - 1; j++){
                curr.add(list.get(j) + list.get(j + 1));
            }
            
            curr.add(1);
            list = curr;
            
        }
        
        return list;
        
    }
}
