class Solution {
    public int[] prevPermOpt1(int[] arr) {
        
        int n=arr.length;
        int flag=0;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                flag=1;
                break;
            }
        }
        
        if(flag==0){
            return arr;
        }
        
        for(int i=n-2;i>=0;i--){
            int max=-1;
            int index=-1;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[i] && arr[j]>=max){
                    max=arr[j];
                    index=j;
                }
            }
            if(index!=-1){
                int temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
                return arr;
            }
        }
        
        return arr;
        
    }
}
