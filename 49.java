class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List<String>> map=new HashMap<>();
        
        for(int i=0;i<strs.length;i++){
            
            String curr=strs[i];
            int count[]=new int[26];
            for(int j=0;j<curr.length();j++){
                count[(int)curr.charAt(j)-97]++;
            }
            
            String val="";
            for(int j=0;j<26;j++){
                int c=count[j];
                val+=Integer.toString(c);
            }
            
            if(map.containsKey(val)){
                List<String> list=map.get(val);
                list.add(curr);
            }
            
            else{
                List<String> list=new ArrayList<String>();
                list.add(curr);
                map.put(val,list);
            }
            
        }
        
        
        Set<String> keys=map.keySet();
        List<List<String>> ans=new ArrayList<>();
        for(String str: keys){
            ans.add(map.get(str));
        }
        
        return ans;
    }
}
