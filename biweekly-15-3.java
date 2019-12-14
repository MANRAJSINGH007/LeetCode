class CombinationIterator {
    
    int n;
    String ans = "";
    boolean[] marked;
    
    public CombinationIterator(String characters, int combinationLength) {
        n = combinationLength;
        ans = "";
        int str = new int[26];
        marked = new boolean[26];
        
        for(int i = 0; i < characters.length(); i++) str[characters.charAt(i) - 'a'] = 1;
        for(int i = 0; i < 26; i++){
            if(str[i] == 1){
                ans += (char)(i + 97);
                marked[i] = true;
                if(ans.length() == n) break;
            }
        }
    }
    
    public boolean nextString(){
        char[] aux = ans.toCharArray();
        int flag = 0;
        int ansIndex = -1;
        l:for(int i = n - 1; i >= 0; i--){
            int ne = 26;
            if(i != n - 1) ne = ans.charAt(i + 1) - 'a';
            char c = ans.charAt(i); 
            int index = c - 'a';
            for(int j = index + 1; j < ne; j++){
                if(!marked[j] && str[j] == 1){
                    flag = 1;
                    ansIndex = i;
                    break l;
                }
            }
        }
        
        if(flag == 0){
            ans = ".";
            return false;
        }
        
        for(int i = ansIndex; i < n; i++) marked[ans.charAt(i) - 'a'] = false;
        int p = ans.charAt(ansIndex) - 'a' + 1;
        for(int i = ansIndex; i < n; i++){
            while(marked[p] || str[p] == 0) p++;
            marked[p] = true;
            aux[i] = (char)(p + 97);
        }
        
        ans = new String(aux);
        return true;
    }
    
    public String next() {
        String aux = new String(ans);
        boolean b = nextString();
        return aux;
    }
    
    public boolean hasNext() {
        if(ans.equals(".")) return false;
        return true;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
