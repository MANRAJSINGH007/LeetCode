class Solution {
    public String customSortString(String s, String t) {
        
        if(t.equals("")){
            return "";
        }
        
        char arr[]=new char[s.length()];
        
        for(int i=0;i<s.length();i++){
            arr[i]=s.charAt(i);
        }
        
        HashMap<Character,Integer> m2=new HashMap<>();
        
        for(int i=0;i<t.length();i++){
            if(m2.containsKey(t.charAt(i))){
                int count=m2.get(t.charAt(i));
                count++;
                m2.put(t.charAt(i),count);
            }
            else{
                m2.put(t.charAt(i),1);
            }
        }
        
        String ans="";
        for(int i=0;i<s.length();i++){
            if(m2.containsKey(arr[i])){
                for(int j=0;j<m2.get(arr[i]);j++){
                    ans+=arr[i];
                }
                
                m2.remove(arr[i]);
            }
        }
        
        Set<Character> keys=m2.keySet();
        for(Character i:keys){
            for(int j=0;j<m2.get(i);j++){
                    ans+=i;
                }
        }
        
        return ans;
    }
}
