class Solution {
    
    public int search(int[] arr, int x) {
        
        int n=arr.length;
        if(n==0){
            return -1;
        }
        int start=0;
        int end=n-1;
        
        int mid=(start+end)/2;
        
        while(start<=end){
            
            if(arr[mid]==x){
                return mid;
            }
            
            if(arr[mid]<arr[end] && x>arr[mid] && x<=arr[end]){
                start=mid+1;
            }
            else if(arr[mid]<arr[end]){
                end=mid-1;
            }
            else if(arr[mid]>arr[end] && x>arr[end] && x<arr[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
            
            mid=(start+end)/2;
            
        }
        
        return -1;
        
    }
}
