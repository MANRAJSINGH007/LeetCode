class Solution {
    public String pushDominoes(String s) {
        
        int n = s.length();
        char[] ans = new char[n];
        for(int i = 0; i < n; i++) ans[i] = '.';
        
        for(int i = 0; i < n;){
            
            if(s.charAt(i) == '.'){
                
                char left = '.';
                if(i != 0) left = ans[i - 1];
                if(left != 'R'){
                    
                    int r = i + 1;
                    while(r < n && s.charAt(r) == '.') r++;
                    if(r == n) return new String(ans);
                    if(s.charAt(r) == 'R'){
                        ans[r] = 'R';
                        i = r + 1;
                        continue ;
                    }
                    
                    if(s.charAt(r) == 'L'){
                        for(int k = i; k <= r - 1; k++) ans[k] = 'L';
                    }
                    
                    ans[r] = s.charAt(r);
                    i = r + 1;
                } 
                
                else{
                    
                    int r = i + 1;
                    while(r < n && s.charAt(r) == '.') r++;
                    
                    if(r == n){
                        for(int k = i; k <n; k++) ans[k] = 'R';
                        return new String(ans);
                    }
                    
                    if(s.charAt(r) == 'R'){
                        for(int k = i; k <= r; k++) ans[k] = 'R';
                        i = r + 1;
                        continue;
                    }
                    
                    int index1 = i;
                    int index2 = r - 1;
                    while(index1 < index2){
                        ans[index1] = 'R';
                        ans[index2] = 'L';
                        index1++;
                        index2--;
                    }
                    
                    i = r;
                }
            } 
            
            else{
                ans[i] = s.charAt(i);
                i++;
            }
        }
        
        return new String(ans);
        
    }
}
