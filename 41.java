class Solution {
    public int firstMissingPositive(int[] arr) {
        
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                arr[i]=0;
            }
        }
        
        for(int i=0;i<n;){
            
            if(arr[i]<=0){
                i++;
                continue;
            }
            
            else if(arr[i]>0){
                
                int index=arr[i]-1;
                if(index>=n || arr[index]<0){
                    i++;
                    continue;
                }
                
                if(index==i){
                    arr[i]=-1;
                    i++;
                    continue;
                }
                
                if(arr[index]==0){
                    arr[index]=-1;
                    i++;
                    continue;
                }
                
                int swap=arr[index];
                arr[index]=-1;
                if(swap>n){
                    i++;
                    continue;
                }
                arr[i]=swap;
            }
            
            
        }
        
        for(int i=0;i<n;i++){
            if(arr[i]>=0){
                return i+1;
            }
        }
        
        return n+1;
        
    }
}
