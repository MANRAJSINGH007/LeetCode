class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int n = queries.length;
        if(n == 0) return new ArrayList<>();
        List<Boolean> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String curr = queries[i];
            if(queries[i].length() < pattern.length()) list.add(false);
            else{
                int i1 = 0;
                int i2 = 0;
                int flag = 0;
                while(i1 < curr.length() && i2 < pattern.length()){
                    if(curr.charAt(i1) == pattern.charAt(i2)){
                        i1 ++;
                        i2 ++;
                    }
                    else{
                        char ch = curr.charAt(i1);
                        if((int)ch <= 90){
                            list.add(false);
                            flag = 1;
                            break;
                        }
                        else{
                            i1 ++;
                        }
                    }
                }
                
                if(flag == 1) continue;
                
                if(i2 < pattern.length()) list.add(false);
                else{
                    while(i1 < curr.length()){
                        if((int)curr.charAt(i1) <= 90){
                            list.add(false);
                            break;
                        }
                        i1 ++;
                    }
                    
                    if(i1 == curr.length()) list.add(true);
                }
            }
        }
        
        return list;
    }
}
