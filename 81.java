class Solution {
    public boolean search(int[] arr, int target) {
        
        int n=arr.length;
        int start=0;
        int end=n-1;
        int mid=(start+end)/2;
        
        while(start<=end){
            mid=(start+end)/2;
            
            if(arr[mid]==target || arr[start]==target || arr[end]==target){
                return true;
            }
            
            if(arr[start]<target && target<arr[mid]){
                end=mid-1;
            }
        
            else if(arr[start]>arr[mid] && (target>arr[start] || target<arr[mid])){
                end=mid-1;
            }
            
            else if(arr[start]==arr[mid] && arr[start]==arr[end]){
                end--;
                start++;
            }
        
            else{
                start=mid+1;
            }
        
        }
        
        return false;
        
    }
}
