class Solution {
    public boolean judgeSquareSum(int c) {
        
        if(c <= 1) return true;
        
        int start = 0;
        int end = (int)Math.sqrt(c);
        
        while(start <= end){
            int sum = (int)Math.pow(start, 2) + (int)Math.pow(end, 2);
            if(sum == c) return true;
            if(sum > c) end--;
            else if(sum < c) start++;
        }
        
        return false;
        
    }
}
