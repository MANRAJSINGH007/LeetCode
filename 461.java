class Solution {
    public int hammingDistance(int x, int y) {
        
        int count=0;
        x=x^y;
        
        while(x>0){
            if(x%2==1){
                count++;
            }
            x/=2;
        }
        
        return count;
        
    }
}
