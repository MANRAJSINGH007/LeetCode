class Solution {
    public List<Integer> findDuplicates(int[] a) {
        
        int n = a.length;
        
        int i = 0;
        
        List<Integer> list = new ArrayList<>();
        
        while(i < n){
            
            int curr = a[i];
            if(curr > 0){
                
                int index = curr - 1;
                if(a[index] > 0){
                    a[i] = a[index];
                    a[index] = 0;
                }
                
                else if(a[index] == 0){
                    a[index] = -1;
                    i++;
                }
                
                else{
                    i++;
                }
                
            }
            
            else{
                i++;
            }
            
        }
        
        for(i = 0 ; i < n; i++){
            if(a[i] == -1){
                list.add(i + 1);
            }
        }
        
        return list;
        
    }
}
