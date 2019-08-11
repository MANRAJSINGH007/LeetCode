class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        
        int n=arr.length;
        
        int start=0;
        int end=0;
        
        int prod=1;
        int count=0;
        
        while(end<n){
            
            while(end<n){
                prod*=arr[end];
                if(prod<k){
                    count+=end-start+1;
                }
                else{
                    break;
                }
                end++;
            }
            
            if(end==n){
                break;
            }
            
            while(start<=end && prod>=k){
                prod/=arr[start];
                start++;
            }
            
            if(start<=end){
                count+=end-start+1;
            }
            
            end++;
            
        }
        
        return count;
        
    }
}
