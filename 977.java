class Solution {
    public int[] sortedSquares(int[] arr) {
        
        int n=arr.length;
        int brr[]=new int[n];
        int index=-1;
        
        for(int i=0;i<n;i++){
            if(arr[i]>=0){
                index=i;
                break;
            }
        }
        
        if(index==-1){
            for(int j=n-1;j>=0;j--){
                brr[n-j-1]=(int)Math.pow(arr[j],2);
            }
            return brr;
        }
        
        if(arr[index]==0){
            int k=0;
            brr[k]=0;
            k++;
            int l=index-1;
            int r=index+1;
            while(l>=0 && r<n){
                if(Math.abs(arr[l])<Math.abs(arr[r])){
                    brr[k]=(int)Math.pow(arr[l],2);
                    l--;
                }
                else{
                    brr[k]=(int)Math.pow(arr[r],2);
                    r++;
                }
                
                k++;
            
            }
            
            if(l<0){
                while(r<n){
                    brr[k]=(int)Math.pow(arr[r],2);
                    r++;
                    k++;
                }
            }
            if(r==n){
                while(l>=0){
                    brr[k]=(int)Math.pow(arr[l],2);
                    l--;
                    k++;
                }
            }
            
            return brr;
        }
        
        else{
            
            int k=0;
            int l=index-1;
            int r=index;
            while(l>=0 && r<n){
                if(Math.abs(arr[l])<Math.abs(arr[r])){
                    brr[k]=(int)Math.pow(arr[l],2);
                    l--;
                }
                else{
                    brr[k]=(int)Math.pow(arr[r],2);
                    r++;
                }
                
                k++;
            
            }
            
            if(l<0){
                while(r<n){
                    brr[k]=(int)Math.pow(arr[r],2);
                    r++;
                    k++;
                }
            }
            if(r==n){
                while(l>=0){
                    brr[k]=(int)Math.pow(arr[l],2);
                    l--;
                    k++;
                }
            }
            
            return brr;
            
        }
        
        
    }
}
