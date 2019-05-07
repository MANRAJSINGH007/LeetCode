class Solution {
    public int majorityElement(int[] arr) {
        
        int n=arr.length;
        int count=0;
        int element=-1;
        for(int i=0;i<n;i++){
            if(i==0){
                count=1;
                element=arr[0];
                continue;
            }
            
            if(count==0 || arr[i]==element){
                count++;
                element=arr[i];
            }
            else{
                count--;
            }
        }
        
        if(count==0){
            return -1;
        }
        
        return element;
    }
}
