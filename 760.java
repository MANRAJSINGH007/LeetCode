class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        
        int n = A.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] ans = new int[n];
        
        for(int i = 0; i < n; i++){
            if(!map.containsKey(B[i])) map.put(B[i], new ArrayList<>());
            map.get(B[i]).add(i);
        }
        
        for(int i = 0; i < n; i++){
            ArrayList<Integer> l = map.get(A[i]);
            ans[i] = l.get(l.size() - 1);
            l.remove(l.size() - 1);
        }
        
        return ans;
    }
}
