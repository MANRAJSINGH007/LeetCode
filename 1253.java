class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        
        int n = colsum.length;
        // 1 in 1st row and 1 in 2nd row
        int count1 = 0; 
        //1 in 1st row and 0 in 2nd row
        int count2 = 0; 
        //0 in 1st row and 1 in 2nd row
        int count3 = 0; 
        
        int x1 = upper;
        int x2 = lower;
        
        for(int i = 0; i < n; i++){
            if(colsum[i] == 2){
                x1 --;
                x2 --;
                count1 ++;
            }
            else if(colsum[i] == 1){
                if(x2 >= x1){
                    x2 --;
                    count3 ++;
                }
                else{
                    x1 --;
                    count2 ++;
                }
            }
            else{
                
            }
            
            //in case it is not possible
            if(x1 < 0 || x2 < 0) return new ArrayList<>();
        }
        
        //if not possible
        if(x1 != 0 || x2 != 0) return new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        
        List<Integer> l1 = ans.get(0);
        List<Integer> l2 = ans.get(1);
        
        for(int i = 0; i < n; i++){
            
            //allocate 1 to both the rows
            if(colsum[i] == 2){
                l1.add(1);
                l2.add(1);
            }
            
            //allocate 0s to both the rows
            else if(colsum[i] == 0){
                l1.add(0);
                l2.add(0);
            }
            
            //either a 1 in first row and 0 in second row or the other way around
            else{
                //if we can have 1 in row 1 and 0 in row 2
                if(count2 > 0){
                    count2 --;
                    l1.add(1);
                    l2.add(0);
                }
                else{
                    count3 --;
                    l1.add(0);
                    l2.add(1);
                }
            }
        }
        
        return ans;
        
    }
}
