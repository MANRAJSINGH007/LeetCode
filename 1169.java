class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        
        int n=transactions.length;
        
        boolean flag[] = new boolean[n];
        
        for(int i=0;i<n;i++) {
            
            String t1[]=transactions[i].split(",");
            
            if(Integer.parseInt(t1[2])>1000){
                flag[i]=true;
            }
            
            for(int j=i+1;j<n;j++) {
                
                String t2[]=transactions[j].split(",");
                
                if(t1[0].equals(t2[0]) && Math.abs(Integer.parseInt(t2[1])-Integer.parseInt(t1[1]))<=60 && !t1[3].equals(t2[3])) {
                    flag[i] = true;
                    flag[j] = true;
                }
            }
        }
        
        List<String> ret=new ArrayList();
        for(int i=0;i<n;i++) {
            
            if(flag[i]) {
                ret.add(transactions[i]);
            }
            
        }
        
        return ret;
        
    }
}
