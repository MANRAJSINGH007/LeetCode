class Solution {
    
    public static boolean func(int n, HashSet<Integer> set){
        
        if(n == 1) return true;
        
        if(n == 0) return false;
        
        if(set.contains(n)) return false;
        
        int sum = 0;
        
        set.add(n);
        
        while(n > 0){
            sum += (int)Math.pow(n%10, 2);
            n /= 10;
        }
        
        return func(sum, set);
        
    }
    
    public boolean isHappy(int n) {
        
        HashSet<Integer> set = new HashSet<>();
        
        return func(n, set);
        
    }
}
