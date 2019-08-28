class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        
        int n1=A.length();
        int n2=B.length();
        
        HashMap<String,Integer> map=new HashMap<>();
        
        String temp="";
        
        for(int i=0;i<n1;i++){
            if(A.charAt(i)==' '){
                if(!map.containsKey(temp)){
                    map.put(temp,1);
                }
                else{
                    int count=map.get(temp);
                    count++;
                    map.put(temp,count);
                }
                
                temp="";
            }
            
            else{
                temp+=A.charAt(i);
            }
        }
        
        if(!temp.equals("")){
            
            if(!map.containsKey(temp)){
                map.put(temp,1);
            }
            else{
                int count=map.get(temp);
                count++;
                map.put(temp,count);
            }
                
        }
        
        temp="";
        
        for(int i=0;i<n2;i++){
            if(B.charAt(i)==' '){
                if(!map.containsKey(temp)){
                    map.put(temp,1);
                }
                else{
                    int count=map.get(temp);
                    count++;
                    map.put(temp,count);
                }
                
                temp="";
            }
            
            else{
                temp+=B.charAt(i);
            }
        }
        
        if(!temp.equals("")){
            
            if(!map.containsKey(temp)){
                map.put(temp,1);
            }
            else{
                int count=map.get(temp);
                count++;
                map.put(temp,count);
            }
                
        }
        
        ArrayList<String> list=new ArrayList<>();
        
        Set<String> keys=map.keySet();
        for(String s:keys){
            if(map.get(s)==1)
                list.add(s);
        }
        
        String[] ans=new String[list.size()];
        
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        
        return ans;
        
        
    }
}
