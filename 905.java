class Solution {
    public int[] sortArrayByParity(int[] A) {
        
        int n=A.length;
        if(n==0 || n==1){
            return A;
        }
        
        int i=0;
        int j=0;
        
        while(j<n && A[j]%2==1){
            j++;
        }
        
        for(;j<n;j++){
            
            if(A[j]%2==0){
                int temp=A[j];
                A[j]=A[i];
                A[i]=temp;
                i++;
            }
            
        }
        
        return A;
        
    }
}
