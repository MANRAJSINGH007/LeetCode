/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    
    public static int search(MountainArray arr, int peak, int target){
        
        int start=0;
        int end=peak-1;
        
        while(start<=end){
            
            int mid=(start+end)/2;
            int curr=arr.get(mid);
            
            if(curr==target){
                return mid;
            }
            
            if(curr>target){
                end=mid-1;
            }
            
            else{
                start=mid+1;
            }
            
        }
        
        return -1;
        
    }
    
    public static int search_right(MountainArray arr, int peak, int target){
        
        int start=peak+1;
        int end=arr.length()-1;

        while(start<=end){

            int mid=(start+end)/2;
            int curr=arr.get(mid);

            if(curr==target){
                return mid;
            }

            if(curr>target){
                start=mid+1;
            }

            else{
                end=mid-1;
            }

        }

        return -1;
    }
    
    public int findInMountainArray(int target, MountainArray arr) {
        
        int n=arr.length();
        
        int start=0;
        int end=n-1;
        
        int mid=(start+end)/2;
        
        while(start<=end){
            
            mid=(start+end)/2;
            int prev=arr.get(mid-1);
            int curr=arr.get(mid);
            int next=arr.get(mid+1);
            
            if(curr>prev && curr>next){
                break;
            }
            
            else if(curr<next){
                start=mid+1;
            }
            
            else{
                end=mid;
            }
        }
        
        if(arr.get(mid)==target){
            return mid;
        }
        
        int min=search(arr,mid,target);
        if(min!=-1){
            return min;
        }
        
        return search_right(arr,mid,target);
        
    }
}
