class Solution {
    public void duplicateZeros(int[] arr) {
        
        int n=arr.length;
        int count=0;
        int index=-1;
        int flag=0;
        for(int i=0;i<n;i++){
            count++;
            if(arr[i]==0){
                if(count==n){
                    flag=1;
                    index=i;
                    break;
                }
                else{
                    count++;
                    index=i;
                }
            }
            if(count==n){
                index=i;
                break;
            }
        }
        
        int dest=n-1;
        int curr=index;
        
        if(flag==1){
            arr[n-1]=0;
            curr--;
            dest--;
        }
        else if(flag==2){
            arr[n-1]=0;
            arr[n-2]=0;
            curr--;
            dest-=2;
        }
        
        while(curr>=0){
            if(arr[curr]==0){
                arr[dest]=0;
                arr[dest-1]=0;
                dest-=2;
            }
            else{
                arr[dest]=arr[curr];
                dest--;
            }
            
            curr--;
        }
        
        return ;
        
    }
}
