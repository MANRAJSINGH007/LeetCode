class Solution {
    public boolean isPerfectSquare(int num) {
        
        if(num <= 1) return true;
        
        int start = 1;
        int end = num;
        
        int mid = (start + end)/2;
        
        while(start <= end){
            mid = (start + end)/2;
            if(mid == num/mid && num % mid == 0) return true;
            if(mid > num/mid) end = mid - 1;
            else start = mid + 1;
        }
        
        return num/mid == mid && num % mid == 0;
    }
}
