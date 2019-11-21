class Solution {
    
    public static int findParent(int[] parent, int i){
        while(parent[i] != i) i = parent[i];
        return i;
    }
    
    public static boolean ifPossible(String s1, String s2, int n){
        
        int flag = 0;
        int[] arr = new int[26];
        char c1 = '.';
        char c2 = '.';
        for(int i = 0; i < n; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(flag == 2) return false;
                if(flag == 0){
                    flag = 1;
                    c1 = s1.charAt(i);
                    c2 = s2.charAt(i);
                }
                else{
                    char c3 = s1.charAt(i);
                    char c4 = s2.charAt(i);
                    if(c3 != c2 || c1 != c4) return false;
                    flag = 2;
                }
            }
            else{
                arr[(int)s1.charAt(i) - 97] ++;
            }
        }

        if(flag == 2) return true;
        if(flag == 1) return false;
        for(int i = 0; i < 26; i++){
            if(arr[i] > 1) return true;
        }
        
        return false;
        
    }
    
    public int numSimilarGroups(String[] A) {
        
        int n = A.length;
        if(n == 0) return 0;
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        
        for(int i = 0; i < n - 1; i++){
            String s1 = A[i];
            int parent1 = findParent(parent, i);
            for(int j = i + 1; j < n; j++){
                String s2 = A[j];
                if(ifPossible(s1, s2, s1.length())){
                    int parent2 = findParent(parent, j);
                    parent[parent2] = parent1;
                }
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(parent[i] == i) count ++;
        }
        
        return count;
        
    }
}
