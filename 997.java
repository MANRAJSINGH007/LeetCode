class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int m=trust.length;
        if(m==0){
            return 1;
        }
        
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> map2=new HashMap<Integer,Integer>();
        
        for(int i=0;i<m;i++){
            
            int sv=trust[i][0];
            int ev=trust[i][1];
            map.put(sv,1);
            
            if(map2.containsKey(ev)){
                int count=map2.get(ev);
                count++;
                map2.put(ev,count);
            }
            
            else{
                map2.put(ev,1);
            }
            
            
        }
        
        Set<Integer> keys=map2.keySet();
        
        for(Integer h : keys){
            if(map2.get(h)==n-1 && !map.containsKey(h)){
                return h;
            }
            
        }
        
        return -1;
    }
}
