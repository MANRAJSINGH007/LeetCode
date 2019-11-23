class Solution {
    
    public static int func(String A, String B, int i, int n, HashMap<String, Integer> map){
        
        if(i == n) return 0;
        
        if(map.containsKey(A.substring(i, n))) return map.get(A.substring(i, n));
        
        if(A.charAt(i) == B.charAt(i)) return func(A, B, i + 1, n, map);
        
        int min = Integer.MAX_VALUE;
        for(int j = i + 1; j < n; j++){
            if(A.charAt(j) == B.charAt(i)){
                String t1 = A.substring(0, i) + B.charAt(i) + A.substring(i + 1, j) + A.charAt(i) + A.substring(j + 1, n);
                int temp = func(t1, B, i + 1, n, map);
                min = Math.min(1 + temp, min);
            }
        }
        
        map.put(A.substring(i, n), min);
        return min;
        
    }
    
    public int kSimilarity(String A, String B) {
        
        int n = A.length();
        HashMap<String, Integer> map = new HashMap<>();
        return func(A, B, 0, n, map);
    }
}
