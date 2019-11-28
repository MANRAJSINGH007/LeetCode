class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        int n = time.length;
        int[] mod = new int[60];
        int count = 0;
        for(int i = 0; i < n; i++){
            int currTime = time[i] % 60;
            if(currTime == 0){
                count += mod[0];
                mod[0]++;
                continue;
            }
            count += mod[60 - currTime];
            mod[currTime]++;
        }
        
        return count;
        
    }
}
