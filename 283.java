class Solution {
    
    public static void swap(int[] arr, int i, int j){
        
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return ;
    }
    
    public void moveZeroes(int[] arr) {
        
        int n=arr.length;
        int i=0;
        int j=0;
        while(i<n){
            
            if(arr[i]!=0){
                swap(arr,i,j);
                j++;
            }
            
            i++;
            
        }
        
        return ;
        
    }
}
