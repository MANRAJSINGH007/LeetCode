class Solution {
    
    static List<List<Integer>> ans = new ArrayList<>();
    
    public static void func(int n, int i, int k, List<Integer> list){
        
        if(i == n + 1 || k == 0){
            if(k != 0) return ;
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < list.size(); j++){
                temp.add(list.get(j));
            }
            ans.add(temp);
            return ;
        }
        
        list.add(i);
        func(n, i + 1, k - 1, list);
        list.remove(list.size() - 1);
        
        func(n, i + 1, k, list);
        return ;
        
    }
    
    public List<List<Integer>> combine(int n, int k) {
        
        ans = new ArrayList<>();
        func(n, 1, k, new ArrayList<>());
        return ans;
        
    }
}
