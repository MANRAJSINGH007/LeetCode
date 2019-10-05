class Solution {
    
    public static void func(int low, int high, List<Integer> list){
        
        Queue<Long> q = new LinkedList<Long>(); 
  
        for(int i = 0; i <= 9; i++)
            q.add((long)i); 
  
        while(q.size() > 0){ 
             
            long p = q.remove(); 
   
            if(p <= (long)high && p >= (long)low){ 
                list.add((int)p); 
            } 
   
            if(p == 0 || p > high) 
                continue;
            
            int l = (int)(p % 10); 
            
            long n1 = p * 10 + (l - 1); 
            long n2 = p * 10 + (l + 1); 
   
            if(l != 0) q.add(n1); 
            
            if(l != 9) q.add(n2);
        }
        
        return ;
        
    }
    
    public List<Integer> countSteppingNumbers(int low, int high) {
        
        List<Integer> ans = new ArrayList<>();
        
        func(low, high, ans); 
        
        Collections.sort(ans);
        
        return ans;
        
    }
}
