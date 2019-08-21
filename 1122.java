class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        int n=arr1.length;
        int m=arr2.length;
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            int curr=arr1[i];
            if(!map.containsKey(curr)){
                map.put(curr,1);
            }
            else{
                int count=map.get(curr);
                count++;
                map.put(curr,count);
            }
        }
        
        int index=0;
        
        for(int i=0;i<m;i++){
            int curr=arr2[i];
            int freq=map.get(curr);
            map.remove(curr);
            for(int j=index;j<index+freq;j++){
                arr1[j]=curr;
            }
            
            index+=freq;
        }
        
        ArrayList<Integer> list=new ArrayList<>();
        Set<Integer> keys=map.keySet();
        for(Integer k: keys){
            list.add(k);
        }
        
        Collections.sort(list);
        for(int p=0;p<list.size();p++){
            int curr=list.get(p);
            for(int j=index;j<index+map.get(curr);j++){
                arr1[j]=curr;
            }
            
            index+=map.get(curr);
        }
        
        return arr1;
        
    }
}
