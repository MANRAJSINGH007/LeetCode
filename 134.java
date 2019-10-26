class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;
        if(n == 0) return 0;
        
        if(n == 1){
            return gas[0] >= cost[0] ? 0 : -1;
        }
        
        int index = 0;
        
        while(index < n){
            
            int i = index;
            int curr = gas[i] - cost[i];
            
            while(curr >= 0){
                i++;
                if(i == n) i = 0;
                if(i == index) return i;
                curr += gas[i] - cost[i];
            }
            
            int prev = index;
            index = i + 1;
            if(index <= prev) return -1;
            
        }
        
        return -1;
        
    }
}
