class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int n=s.length();
        if(s==null){
            return new ArrayList<>();
        }
        
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        
        int start[]=new int[26];
        int end[]=new int[26];
        
        for(int i=0;i<26;i++){
            start[i]=-1;
            end[i]=-1;
        }
        
        for(int i=0;i<s.length();i++){
            
            char curr=s.charAt(i);
            int num=(int)curr-97;
            if(start[num]==-1){
                start[num]=i;
                end[num]=i;
                continue;
            }
            else{
                end[num]=i;
            }
            
        }
        
        // for(int i=0;i<26;i++){
        //     System.out.println(start[i]+" "+end[i]);
        // }
        
        for(int i=0;i<26;i++){
            if(start[i]!=-1){
                map.put(start[i],end[i]);
            }
        }
        
        List<Integer> list=new ArrayList<>();
        
        int find=0;
        while(find<s.length()){
            
            while(find<s.length() && !map.containsKey(find)){
                find++;
            }
            int old=find;
            int ending=map.get(find);
            while(find<ending){
                if(map.containsKey(find)){
                    ending=Math.max(ending,map.get(find));
                }
                find++;
            }
            list.add(ending-old+1);
            find=ending+1;
        }
        
        return list;
    }
}
