class Solution {
    
    public static ArrayList<String> split(String str){
        
        int n = str.length();
        String temp = "";
        
        ArrayList<String> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            if(str.charAt(i) == ' '){
                ans.add(temp);
                temp = "";
            }
            else{
                temp += str.charAt(i);
            }
        }
        
        if(!temp.equals("")){
            ans.add(temp);
        }
        
        return ans;
    }
    
    
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        
        int n = phrases.length;
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i = 0; i < n - 1; i++){
            
            String curr = phrases[i];
            ArrayList<String> first = split(curr);
            
            for(int j = i + 1; j < n; j++){
                
                String other = phrases[j];
                ArrayList<String> second = split(other);
                
                String temp1 = "";
                if(first.get(first.size() - 1).equals(second.get(0))){
                    for(int k = 0; k < first.size() - 1; k++){
                        temp1 += first.get(k) + " ";
                    }
                    temp1 += other;
                    if(!map.containsKey(temp1))
                        map.put(temp1, 1);
                }
                
                String temp2 = "";
                if(second.get(second.size() - 1).equals(first.get(0))){
                    for(int k = 0; k < second.size() - 1; k++){
                        temp2 += second.get(k) + " ";
                    }
                    temp2 += curr;
                    if(!temp1.equals(temp2) && !map.containsKey(temp2)){
                        map.put(temp2, 1); 
                    }   
                }
            }
        }
        
        List<String> list = new ArrayList<>();
        
        Set<String> keys = map.keySet();
        for(String t : keys){
            list.add(t);
        }
        
        Collections.sort(list);
        return list;
        
    }
}
