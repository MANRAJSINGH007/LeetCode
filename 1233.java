class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        int n = folder.length;
        Arrays.sort(folder);
        
        HashSet<String> set = new HashSet<>();
        
        List<String> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            
            String curr = folder[i];
            String temp = "";
            int flag = 0;
            
            for(int j = 0; j < curr.length(); j++){
                if(curr.charAt(j) == '/'){
                    if(set.contains(temp)){
                        flag = 1;
                        break;
                    }
                }
                temp += curr.charAt(j);
            }
            
            if(flag == 0){
                ans.add(curr);
            }
            
            set.add(curr);
        }
        
        // System.out.print(set.size());
        
        return ans;
        
    }
}
