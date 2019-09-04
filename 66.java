class Solution {
    public int[] plusOne(int[] arr) {
        
        int n=arr.length;
        int i=0;
        while(i<n && arr[i]==0){
            i++;
        }
        
        if(i==n){
            int ans[]={1};
            return ans;
        }
        
        else{
            if(i==0){
                int carry=1;
                int j=n-1;
                for(j=n-1;j>=0;j--){
                    int sum=carry+arr[j];
                    arr[j]=sum%10;
                    carry=sum/10;
                    if(carry==0){
                        break;
                    }
                }
                
                if(j==-1){
                    if(carry==0){
                        return arr;
                    }
                    else{
                        int ans[]=new int[n+1];
                        ans[0]=1;
                        for(int k=1;k<=n;k++){
                            ans[k]=arr[k-1];
                        }
                        
                        return ans;
                    }
                }
                
                return arr;
            }
            
            else{
                int index=i-1;
                int carry=1;
                for(int j=n-1;j>index;j--){
                    int sum=carry+arr[j];
                    arr[j]=sum%10;
                    carry=sum/10;
                    if(carry==0){
                        break;
                    }
                }
                if(carry==1){
                    arr[index]=1;
                    int ans[]=new int[n-index];
                    for(int k=0;k<n-index;k++){
                        ans[k]=arr[index+k];
                    }
                    
                    return ans;
                }
                
                else{
                    int ans[]=new int[n-index-1];
                    for(int k=0;k<n-index-1;k++){
                        ans[k]=arr[index+k+1];
                    }
                    
                    return ans;
                }
            }
        }
        
    }
}
